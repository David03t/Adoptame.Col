/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.conectarDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.MascotaBean;
import models.MascotaBeanValidation;
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
    @RequestMapping(value = "addMascotas.htm",method = RequestMethod.POST)
    public ModelAndView AddMascotas ( 
            @ModelAttribute("mascotas") MascotaBean masform,
            BindingResult result,
            SessionStatus status){
        this.vistamascotas.validate(masform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("mascotas", new MascotaBean());
            mav.setViewName("views/addMascotas");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            String sql = "insert into mascota (nombre, categoria, raza, edad, descripcion, genero) "
                + "values (?,?,?,?,?,?)";
            jdbcTemplate.update(sql, masform.getNombre(), masform.getCategoria(), masform.getRaza(), masform.getEdad(),masform.getDescripcion(), masform.getGenero());
            mav.addObject("mascotas", new MascotaBean());
            mav.setViewName("redirect:/listaMascotas.htm");
            return mav;
        } 
    }
     @RequestMapping("borrarMascota.htm")
    public ModelAndView borrarMascota(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from mascota where id = ?";
        this.jdbcTemplate.update(sql,id);
        mav.setViewName("redirect:/listaMascotas.htm");
        return mav;
    }
    @RequestMapping(value = "updateMascota.htm", method = RequestMethod.GET)
    public ModelAndView actualizarMascota (HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        MascotaBean mascota = consultarMascotaId (id);
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
                    }
                    
                    return mascota;
                }
            }
        );
    }
    @RequestMapping(value = "updateMascota.htm",method = RequestMethod.POST)
    public ModelAndView actualizarMascota ( 
            @ModelAttribute("mascotas") MascotaBean masform,
            BindingResult result,
            SessionStatus status){
        this.vistamascotas.validate(masform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("mascotas", new MascotaBean());
            mav.setViewName("views/updateMascota");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            String sql = "update mascota set nombre = ?, categoria = ?, raza = ?, edad = ?, descripcion = ?, genero = ? where id  = ? ";
            jdbcTemplate.update(sql, masform.getNombre(), masform.getCategoria(), masform.getRaza(), masform.getEdad(),masform.getDescripcion(), masform.getGenero(), masform.getId());
            mav.setViewName("redirect:/listaMascotas.htm");
            return mav;
        } 
    }
}
