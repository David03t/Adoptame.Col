/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

/**
 *
 * @author DAVID
 */
public class UsuarioDao {
    JdbcTemplate jdbcTemplate;
    conectarDB conDB = new conectarDB();
    
    public List ConsultarUsuariosAdopcion(){
        List datos = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql= "select * from usuario where numero_adopciones <4";
        datos= this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    public List consultarUsuariosById(int id){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where id = ?";
        user = this.jdbcTemplate.queryForList(sql, id);
        return user;
    }
    public List consultarUsuariosByNombre(String nombrep){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where nombrep = ?";
        user = this.jdbcTemplate.queryForList(sql, nombrep);
        return user;
    }
    public List consultarUsuariosByApellido(String apellidop){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where apellidop = ?";
        user = this.jdbcTemplate.queryForList(sql, apellidop);
        return user;
    }
    public List consultarUsuariosByTelefono(String telefonop){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where telefonop = ?";
        user = this.jdbcTemplate.queryForList(sql, telefonop);
        return user;
    }
    public List consultarUsuariosByCorreo(String correop){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where correop = ?";
        user = this.jdbcTemplate.queryForList(sql, correop);
        return user;
    }
    public List consultarUsuariosByEdad(String edadp){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where edadp = ?";
        user = this.jdbcTemplate.queryForList(sql, edadp);
        return user;
    }
    public List consultarUsuariosByDireccion(String direccionp){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where direccionp = ?";
        user = this.jdbcTemplate.queryForList(sql, direccionp);
        return user;
    }
    public List consultarUsuariosByCiudad(String ciudadp){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where ciudadp = ?";
        user = this.jdbcTemplate.queryForList(sql, ciudadp);
        return user;
    }
    public List consultarUsuariosByGenero(String generop){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from usuario where generop = ?";
        user = this.jdbcTemplate.queryForList(sql, generop);
        return user;
    }
    public void updatePersonaSinFoto (UsuarioBean user, List lista) {
        this.jdbcTemplate = new JdbcTemplate (conDB.conDB());
        ArrayList<String> Listado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println("error aca... "+ i + "-" + items.size());
            FileItem fileItem = (FileItem) lista.get(i);
            Listado.add(fileItem.getString());
        }
            user.setNombrep(Listado.get(0));
            user.setApellidop(Listado.get(1));
            user.setTelefonop(Listado.get(2));
            user.setCorreop(Listado.get(3));
            user.setEdadp(Listado.get(4));
            user.setDireccionp(Listado.get(5));
            user.setCiudadp(Listado.get(6));
            user.setGenerop(Listado.get(7));
            String sql = "update usuario set nombrep = ?, apellidop = ?, telefonop = ?, correop = ?, edadp = ?, direccionp = ?, ciudadp = ?, generop = ? where id  = ? ";
            jdbcTemplate.update(sql, user.getNombrep(), user.getApellidop(), user.getTelefonop(), user.getCorreop(),user.getEdadp(), user.getDireccionp(), user.getCiudadp(), user.getGenerop(), user.getId());
    }
    private static final String UPLOAD_DIRECTORY = "..\\..\\web\\images\\personas";
    public void updatePersonaConFoto (UsuarioBean user, boolean isMultipart,HttpServletRequest req, List items) {
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        ArrayList<String> Listado = new ArrayList<>();
            if(isMultipart){
                DiskFileItemFactory file = new DiskFileItemFactory();
                file.setRepository(new File(System.getProperty("java.io.tmpdir")));
                ServletFileUpload fileUpload = new ServletFileUpload(file);
                String uploadPath = req.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
                String deletePath = req.getServletContext().getRealPath("") + File.separator;
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()){
                    uploadDir.mkdir();
                }for (int i = 0; i < items.size(); i++){
                    FileItem fileItem = (FileItem) items.get(i);
                    if(!fileItem.isFormField()){
                        String fileName = new File(fileItem.getName()).getName();
                        String filePath = uploadPath + File.separator + "ID - " + Listado.get(0) + "" + fileName;
                        File uploadFile = new File (filePath);
                        String nameFile = ("images/personas/" + "ID - " + Listado.get(0) + "" + fileName);
                        try{
                            borrarImagenActualizada(user.getFotoOld(), deletePath);
                            uploadFile.delete();
                            fileItem.write(uploadFile);
                            user.setFoto(nameFile);
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
            String sql = "update usuario set nombrep = ?, apellidop = ?, telefonop = ?, correop = ?, edadp = ?, direccionp = ?, ciudadp = ?, generop = ?, foto = ? , fotoOld = ? where id  = ? ";
            jdbcTemplate.update(sql, user.getNombrep(), user.getApellidop(), user.getTelefonop(), user.getCorreop(),user.getEdadp(), user.getDireccionp(), user.getCiudadp(), user.getGenerop(), user.getFoto(), user.getFoto(), user.getId());
    }
    public void borrarImagenActualizada(String foto, String deletePath){
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        File borrar = new File(deleteFile);
        if(borrar.delete()){
            System.out.print("borrado");
        }else{
            System.out.print("no se pudo borrar");
        }
    }
    public void borrarImagen(String foto, String deletePath, int id){
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        this.jdbcTemplate= new JdbcTemplate(conDB.conDB());
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        File borrar = new File(deleteFile);
        if(borrar.delete()){
            System.out.print("borrado");
            String sql = "delete from usuario where id = ?";
            jdbcTemplate.update(sql,id);
        }else{
            System.out.print("no se pudo borrar");
        }
    }
}