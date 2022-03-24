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
import models.MascotaBean;
import models.UsuarioBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author DAVID
 */
public class mascotaDao {
    JdbcTemplate jdbcTemplate;
    conectarDB conDB = new conectarDB();
    
    public List ConsultarMascotasAdopcion(){
        List datos = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql= "Select * from mascota where estado = 0";
        datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    public List consultarMascotasById(int id){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where id = ?";
        masc = this.jdbcTemplate.queryForList(sql, id);
        return masc;
    }
    public List consultarMascotasByNombre(String nombre){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where nombre = ?";
        masc = this.jdbcTemplate.queryForList(sql, nombre);
        return masc;
    }
    public List consultarMascotasByCategoria(String categoria){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where categoria = ?";
        masc = this.jdbcTemplate.queryForList(sql, categoria);
        return masc;
    }
    public List consultarMascotasByRaza(String raza){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where raza = ?";
        masc = this.jdbcTemplate.queryForList(sql, raza);
        return masc;
    }
    public List consultarMascotasByEdad(String edad){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where edad = ?";
        masc = this.jdbcTemplate.queryForList(sql, edad);
        return masc;
    }
    public List consultarMascotasByDescripcion(String descripcion){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where descripcion = ?";
        masc = this.jdbcTemplate.queryForList(sql, descripcion);
        return masc;
    }
    public List consultarMascotasByGenero(String genero){
        List masc = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select * from mascota where genero = ?";
        masc = this.jdbcTemplate.queryForList(sql, genero);
        return masc;
    }
    public void updateMascotaSinFoto (MascotaBean masc, List lista) {
        this.jdbcTemplate = new JdbcTemplate (conDB.conDB());
        ArrayList<String> Listado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println("error aca... "+ i + "-" + items.size());
            FileItem fileItem = (FileItem) lista.get(i);
            Listado.add(fileItem.getString());
        }
            masc.setNombre(Listado.get(0));
            masc.setCategoria(Listado.get(1));
            masc.setRaza(Listado.get(2));
            masc.setEdad(Listado.get(3));
            masc.setDescripcion(Listado.get(4));
            masc.setGenero(Listado.get(5));
            String sql = "update mascota set nombre = ?, categoria = ?, raza = ?, edad = ?, descripcion = ?, genero = ? where id  = ? ";
            jdbcTemplate.update(sql, masc.getNombre(), masc.getCategoria(), masc.getRaza(), masc.getEdad(),masc.getDescripcion(), masc.getGenero(), masc.getId());
    }
    private static final String UPLOAD_DIRECTORY = "..\\..\\web\\images\\mascota";
    public void updateMascotaConFoto (MascotaBean masc, boolean isMultipart,HttpServletRequest req, List items) {
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
                        String nameFile = ("images/mascota/" + "ID - " + Listado.get(0) + "" + fileName);
                        try{
                            borrarImagenActualizada(masc.getFotoOld(), deletePath);
                            uploadFile.delete();
                            fileItem.write(uploadFile);
                            masc.setFoto(nameFile);
                        }catch(Exception e){
                            System.out.print("Escritura..." + e.getMessage());
                        }
                        masc.setFoto(nameFile);
                    }else{
                        Listado.add(fileItem.getString());
                    }
                    
                }  
                    masc.setNombre(Listado.get(0));
                    masc.setCategoria(Listado.get(1));
                    masc.setRaza(Listado.get(2));
                    masc.setEdad(Listado.get(3));
                    masc.setDescripcion(Listado.get(4));
                    masc.setGenero(Listado.get(5));
            }
            String sql = "update mascota set nombre = ?, categoria = ?, raza = ?, edad = ?, descripcion = ?, genero = ?, foto = ? , fotoOld = ? where id  = ? ";
            jdbcTemplate.update(sql, masc.getNombre(), masc.getCategoria(), masc.getRaza(), masc.getEdad(),masc.getDescripcion(), masc.getGenero(),masc.getFoto(),masc.getFoto(), masc.getId());
    }
    public void borrarImagenActualizada(String foto, String deletePath){
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        System.out.print(deleteFile);
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
            String sql = "delete from mascota where id = ?";
            jdbcTemplate.update(sql,id);
        }else{
            System.out.print("no se pudo borrar");
        }
    }
}
