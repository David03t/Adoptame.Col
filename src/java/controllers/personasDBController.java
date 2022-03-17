/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.UsuarioDao;
import Dao.conectarDB;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import models.usuario_mascotaBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
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
public class personasDBController {
    private JdbcTemplate jdbcTemplate;
    private UsuarioBeanValidation vistapersonas; 
    public personasDBController() {
        conectarDB con = new conectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.vistapersonas = new UsuarioBeanValidation();
    }
    @RequestMapping("listaPersonas")
    public ModelAndView formPersona(){
    ModelAndView mav = new ModelAndView();
    String sql = "select * from usuario";
    List datos = jdbcTemplate.queryForList(sql);
    mav.addObject("usuarios",datos);
    mav.setViewName("views/listaPersonas");
    return mav;
    }
    @RequestMapping(value = "addPersonas.htm",method = RequestMethod.GET)
    public ModelAndView AddUsuarios(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("persona", new UsuarioBean());
        mav.setViewName("views/addPersonas");
        return mav;
    }


    
//         @RequestMapping(value = "addPersonas.htm",method = RequestMethod.POST)
//    public ModelAndView AddUsuarios ( 
//            @ModelAttribute("persona") UsuarioBean perform,
//            BindingResult result,
//            SessionStatus status){
//        this.vistapersonas.validate(perform, result);
//        if(result.hasErrors()){
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("personas", new UsuarioBean());
//            mav.setViewName("views/addPersonas");
//            return mav;
//        }else{
//            ModelAndView mav = new ModelAndView();
//            String sql = "insert into usuario (nombrep, apellidop, telefonop, correop, edadp, direccionp, ciudadp, generop) "
//                + "values (?,?,?,?,?,?,?,?)";
//            jdbcTemplate.update(sql, perform.getNombrep(), perform.getApellidop(), perform.getTelefonop(), perform.getCorreop(),perform.getEdadp(), perform.getDireccionp(), perform.getCiudadp(), perform.getGenerop());
//            mav.addObject("persona", new UsuarioBean());
//            mav.setViewName("redirect:/listaPersonas.htm");
//            return mav;
//        } 
//    }
    @RequestMapping(value = "addPersonas.htm",method = RequestMethod.POST)
    public ModelAndView AddUsuarios(HttpServletRequest req){
        UsuarioBean user = new UsuarioBean();
        ModelAndView mav = new ModelAndView();
        String uploadFilePath = req.getSession().getServletContext().getRealPath("../../web/images/personas/");
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            ArrayList<String> Listado = new ArrayList<>();
            if(isMultipart){
                FileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileUpload = new ServletFileUpload(file);
                List<FileItem> items = null;
                try{
                    items = fileUpload.parseRequest(req);
                }catch(FileUploadException ex){
                    System.out.print("Carga..." + ex.getMessage());
                }
                for (int i = 0; i < items.size(); i++){
                    FileItem fileItem = (FileItem) items.get(i);
                    if(!fileItem.isFormField()){
                        File f = new File(fileItem.getName());
                        String nameFile = ("images/personas/"+ f.getName());
                        File uploadFile = new File(uploadFilePath, f.getName());
                        try{
                            fileItem.write(uploadFile);
                                
                        }catch(Exception e){
                            System.out.print("Escritura..." + e.getMessage());
                        }
                        user.setFoto(nameFile);
                    }else{
                        Listado.add(fileItem.getString());
                    }
                    
                }  
                user.setNombrep(Listado.get(0));
                    user.setApellidop(Listado.get(1));
                    user.setTelefonop(Listado.get(2));
                    user.setCorreop(Listado.get(3));
                    user.setEdadp(Listado.get(4));
                    user.setDireccionp(Listado.get(5));
                    user.setCiudadp(Listado.get(6));
                    user.setGenerop(Listado.get(7));
            }
            String sql = "insert into usuario (nombrep, apellidop, telefonop, correop, edadp, direccionp, ciudadp, generop, foto) "
                + "values (?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, user.getNombrep(), user.getApellidop(), user.getTelefonop(), user.getCorreop(),user.getEdadp(), user.getDireccionp(), user.getCiudadp(), user.getGenerop(), user.getFoto());
            mav.addObject("persona", new UsuarioBean());
            mav.setViewName("redirect:/listaPersonas.htm");
            return mav;
    }
    
    
    @RequestMapping("borrarPersona.htm")
    public ModelAndView borrarPersona(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from usuario where id = ?";
        this.jdbcTemplate.update(sql,id);
        mav.setViewName("redirect:/listaPersonas.htm");
        return mav;
    }
    
    @RequestMapping(value = "updatePersona.htm", method = RequestMethod.GET)
    public ModelAndView actualizarPersona (HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        UsuarioBean usuario = consultarUsuarioId (id);
        mav.addObject("persona", usuario);
        mav.setViewName("views/updatePersona");
        return mav;
    }
    public UsuarioBean consultarUsuarioId(int id){
        UsuarioBean usuario = new UsuarioBean();
        String sql = "select * from usuario where id ="+ id;
        return (UsuarioBean)jdbcTemplate.query(
            sql, new ResultSetExtractor<UsuarioBean>(){
                @Override
                public UsuarioBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if(rs.next()){
                        usuario.setNombrep(rs.getString("nombrep"));
                        usuario.setApellidop(rs.getString("Apellidop"));
                        usuario.setTelefonop(rs.getString("Telefonop"));
                        usuario.setCorreop(rs.getString("Correop"));
                        usuario.setEdadp(rs.getString("Edadp"));
                        usuario.setDireccionp(rs.getString("Direccionp"));
                        usuario.setCiudadp(rs.getString("Ciudadp"));
                        usuario.setGenerop(rs.getString("Generop"));
                        usuario.setFoto(rs.getString("foto"));
                    }
                    
                    return usuario;
                }
            }
        );
    }
    @RequestMapping(value = "updatePersona.htm",method = RequestMethod.POST)
    public ModelAndView actualizarPersona ( 
            @ModelAttribute("persona") UsuarioBean perform,
            BindingResult result,
            SessionStatus status){
        this.vistapersonas.validate(perform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("personas", new UsuarioBean());
            mav.setViewName("views/updatePersona");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            String sql = "update usuario set nombrep = ?, apellidop = ?, telefonop = ?, correop = ?, edadp = ?, direccionp = ?, ciudadp = ?, generop = ? where id  = ? ";
            jdbcTemplate.update(sql, perform.getNombrep(), perform.getApellidop(), perform.getTelefonop(), perform.getCorreop(),perform.getEdadp(), perform.getDireccionp(), perform.getCiudadp(), perform.getGenerop(), perform.getId());
            mav.setViewName("redirect:/listaPersonas.htm");
            return mav;
        } 
    }
    
    @RequestMapping(value = "consultarPersonaId.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaId (){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaId");
        return mav;
    }
    @RequestMapping(value="consultarPersonaId.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaId (
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        int id = per.getId();
        mav.addObject("persona", user.consultarUsuariosById(id)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaNombre.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaNombre (){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaNombre");
        return mav;
    }
    @RequestMapping(value="consultarPersonaNombre.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaNombre (
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String nombrep = per.getNombrep();
        mav.addObject("persona", user.consultarUsuariosByNombre(nombrep)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaApellido.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaApellido(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaApellido");
        return mav;
    }
    @RequestMapping(value="consultarPersonaApellido.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaApellido(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String apellidop = per.getApellidop();
        mav.addObject("persona", user.consultarUsuariosByApellido(apellidop)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaTelefono.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaTelefono(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaTelefono");
        return mav;
    }
    @RequestMapping(value="consultarPersonaTelefono.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaTelefono(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String telefonop = per.getTelefonop();
        mav.addObject("persona", user.consultarUsuariosByTelefono(telefonop)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaCorreo.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaCorreo(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaCorreo");
        return mav;
    }
    @RequestMapping(value="consultarPersonaCorreo.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaCorreo(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String correop = per.getCorreop();
        mav.addObject("persona", user.consultarUsuariosByCorreo(correop)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaEdad.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaEdad(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaEdad");
        return mav;
    }
    @RequestMapping(value="consultarPersonaEdad.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaEdad(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String edadp = per.getEdadp();
        mav.addObject("persona", user.consultarUsuariosByEdad(edadp)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaDireccion.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaDireccion(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaDireccion");
        return mav;
    }
    @RequestMapping(value="consultarPersonaDireccion.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaDireccion(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String direccionp = per.getDireccionp();
        mav.addObject("persona", user.consultarUsuariosByDireccion(direccionp)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaCiudad.htm", method = RequestMethod.GET)
    public ModelAndView consultarPersonaCiudad(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaCiudad");
        return mav;
    }
    @RequestMapping(value="consultarPersonaCiudad.htm", method=RequestMethod.POST)
        public ModelAndView consultarPersonaCiudad(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String ciudadp = per.getCiudadp();
        mav.addObject("persona", user.consultarUsuariosByCiudad(ciudadp)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
    @RequestMapping(value = "consultarPersonaGenero.htm", method = RequestMethod.GET)
    public ModelAndView consultarUsuariosGenero(){
       ModelAndView mav = new ModelAndView();
       UsuarioBean persona = new UsuarioBean();
        mav.addObject("persona", persona);
        mav.setViewName("views/consultarPersonaGenero");
        return mav;
    }
    @RequestMapping(value="consultarPersonaGenero.htm", method=RequestMethod.POST)
        public ModelAndView consultarUsuariosGenero(
        @ModelAttribute ("persona") UsuarioBean per,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        String generop = per.getGenerop();
        mav.addObject("persona", user.consultarUsuariosByGenero(generop)); 
        mav.setViewName ("views/vistaConsultaPersona");
        return mav;
    }
}
