/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.conectarDB;
import Dao.mascotaDao;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.MascotaBean;
import models.MascotaBeanValidation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SENA
 */
@Controller
public class mascotasDBController {
    private JdbcTemplate jdbcTemplate;
     private MascotaBeanValidation vistamascotas; 
    public mascotasDBController(){
        conectarDB con = new conectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.vistamascotas = new MascotaBeanValidation();
    }
    @RequestMapping("listaMascotas")
    public ModelAndView formMascota(){
        ModelAndView mav = new ModelAndView();
        String sql = "select * from mascota";
        List datos = jdbcTemplate.queryForList(sql);
        mav.addObject("mascotas",datos);
        mav.setViewName("views/listaMascotas");
        return mav;
    }
    @RequestMapping(value = "addMascotas.htm",method = RequestMethod.GET)
    public ModelAndView AddMascotas(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("mascotas", new MascotaBean());
        mav.setViewName("views/addMascotas");
        return mav;
    }
        private static final String UPLOAD_DIRECTORY = "..\\..\\web\\images\\mascota";
        @RequestMapping(value = "addMascotas.htm",method = RequestMethod.POST)
    public ModelAndView AddMascotas (MascotaBean masform, HttpServletRequest req){
            ModelAndView mav = new ModelAndView();
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            ArrayList<String> Listado = new ArrayList<>();
            if(isMultipart){
                DiskFileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileUpload = new ServletFileUpload(file);
                file.setRepository(new File(System.getProperty("java.io.tmpdir")));
                String uploadPath = req.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()){
                    uploadDir.mkdir();
                }List<FileItem> items = null;
                try{
                    items = fileUpload.parseRequest(req);
                }catch(FileUploadException ex){
                    System.out.print("Carga..." + ex.getMessage());
                }
                for (int i = 0; i < items.size(); i++){
                    FileItem fileItem = (FileItem) items.get(i);
                    if(!fileItem.isFormField()){
                        String fileName = new File(fileItem.getName()).getName();
                        String filePath = uploadPath + File.separator + "ID - " + Listado.get(0) + "" + fileName;
                        File uploadFile = new File (filePath);
                        String nameFile = ("images/mascota/" + "ID - " + Listado.get(0) + "" + fileName);
                        try{
                            fileItem.write(uploadFile);
                            
                        }catch(Exception e){
                            System.out.print("Escritura..." + e.getMessage());
                        }
                        masform.setFoto(nameFile);
                    }else{
                        Listado.add(fileItem.getString());
                    }
                }
                masform.setNombre(Listado.get(0));
                masform.setCategoria(Listado.get(1));
                masform.setRaza(Listado.get(2));
                masform.setEdad(Listado.get(3));
                masform.setDescripcion(Listado.get(4));
                masform.setGenero(Listado.get(5));
            }
            String sql = "insert into mascota (nombre, categoria, raza, edad, descripcion, genero,foto,fotoOld, estado) "
                + "values (?,?,?,?,?,?,?,?,0)";
            jdbcTemplate.update(sql, masform.getNombre(), masform.getCategoria(), masform.getRaza(), masform.getEdad(),masform.getDescripcion(), masform.getGenero(), masform.getFoto(),masform.getFoto());
            mav.addObject("mascotas", new MascotaBean());
            mav.setViewName("redirect:/listaMascotas.htm");
            return mav;
    }
     @RequestMapping("borrarMascota.htm")
    public ModelAndView borrarMascota(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascdao= new mascotaDao();
        int id = Integer.parseInt(req.getParameter("id"));
        String deletePath = req.getServletContext().getRealPath("")+ File.separator;
        String foto = req.getParameter("foto");
        mascdao.borrarImagen(foto, deletePath, id);
        mav.setViewName("redirect:/listaMascotas.htm");
        return mav;
    }
    @RequestMapping(value = "updateMascota.htm", method = RequestMethod.GET)
    public ModelAndView actualizarMascota (HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String fotoOld = req.getParameter("fotoOld");
        MascotaBean mascota = consultarMascotaId (id);
        mascota.setFotoOld(fotoOld);
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/updateMascota");
        return mav;
    }
    public MascotaBean consultarMascotaId(int id){
        MascotaBean mascota = new MascotaBean();
        String sql = "select * from mascota where id ="+ id;
        return (MascotaBean)jdbcTemplate.query(
            sql, new ResultSetExtractor<MascotaBean>(){
                @Override
                public MascotaBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if(rs.next()){
                        mascota.setNombre(rs.getString("nombre"));
                        mascota.setCategoria(rs.getString("categoria"));
                        mascota.setRaza(rs.getString("raza"));
                        mascota.setEdad(rs.getString("edad"));
                        mascota.setDescripcion(rs.getString("descripcion"));
                        mascota.setGenero(rs.getString("genero"));
                        mascota.setFoto(rs.getString("foto"));
                    }
                    
                    return mascota;
                }
            }
        );
    }

    @RequestMapping(value = "updateMascota.htm",method = RequestMethod.POST)
    public ModelAndView actualizarMascota (MascotaBean masc, HttpServletRequest req ){
            ModelAndView mav = new ModelAndView();
            mascotaDao mascDao = new mascotaDao();
            ArrayList<String> Listado = new ArrayList<>();
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            DiskFileItemFactory file = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(file);
            
            List<FileItem> items = null;
            try{
            items = fileUpload.parseRequest(req);
            for (int i = 0; i < items.size(); i++){
                FileItem fileItem = (FileItem) items.get(i);
                Listado.add(fileItem.getString());
            }
        }catch(FileUploadException ex){
            System.out.print("error en la carga de la imagen ellenteController/updateCliente..." + ex.getMessage());
        }
            if(Listado.get(6).isEmpty() || Listado.get(6).equals("")|| Listado.get(6).equals(null)){
                mascDao.updateMascotaSinFoto(masc,items);
            }else{
                mascDao.updateMascotaConFoto(masc, isMultipart, req, items);
//                System.out.print("nada");
            }
            mav.setViewName("redirect:/listaMascotas.htm");
            return mav;
        
    }
    @RequestMapping(value = "consultarMascotaId.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasById (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaId");
        return mav;
    }
    @RequestMapping(value="consultarMascotaId.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasById (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        int id = masc.getId();
        mav.addObject("mascotas", mascota.consultarMascotasById(id)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaNombre.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByNombre (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaNombre");
        return mav;
    }
    @RequestMapping(value="consultarMascotaNombre.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByNombre (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String nombre  = masc.getNombre();
        mav.addObject("mascotas", mascota.consultarMascotasByNombre(nombre)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaCategoria.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByCategoria (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaCategoria");
        return mav;
    }
    @RequestMapping(value="consultarMascotaCategoria.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByCategoria (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String categoria = masc.getCategoria();
        mav.addObject("mascotas", mascota.consultarMascotasByCategoria(categoria)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaRaza.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByRaza (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaRaza");
        return mav;
    }
    @RequestMapping(value="consultarMascotaRaza.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByRaza (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String raza = masc.getRaza();
        mav.addObject("mascotas", mascota.consultarMascotasByRaza(raza)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaEdad.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByEdad (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaEdad");
        return mav;
    }
    @RequestMapping(value="consultarMascotaEdad.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByEdad (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String edad = masc.getEdad();
        mav.addObject("mascotas", mascota.consultarMascotasByEdad(edad)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaDescripcion.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByDescripcion (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaDescripcion");
        return mav;
    }
    @RequestMapping(value="consultarMascotaDescripcion.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByDescripcion (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String descripcion = masc.getDescripcion();
        mav.addObject("mascotas", mascota.consultarMascotasByDescripcion(descripcion)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
    @RequestMapping(value = "consultarMascotaGenero.htm", method = RequestMethod.GET)
    public ModelAndView consultarMascotasByGenero (){
       ModelAndView mav = new ModelAndView();
       MascotaBean mascota = new MascotaBean();
        mav.addObject("mascotas", mascota);
        mav.setViewName("views/consultarMascotaGenero");
        return mav;
    }
    @RequestMapping(value="consultarMascotaGenero.htm", method=RequestMethod.POST)
        public ModelAndView consultarMascotasByGenero (
        @ModelAttribute ("mascotas") MascotaBean masc,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        mascotaDao mascota= new mascotaDao();
        String genero = masc.getGenero();
        mav.addObject("mascotas", mascota.consultarMascotasByGenero(genero)); 
        mav.setViewName ("views/vistaConsultaMascota");
        return mav;
    }
}
