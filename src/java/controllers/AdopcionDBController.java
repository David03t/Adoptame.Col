/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.UsuarioDao;
import Dao.conectarDB;
import Dao.mascotaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.usuario_mascotaBean;
import models.usuario_mascotaBeanValidation;
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
 * @author DAVID
 */
@Controller
public class AdopcionDBController {
    private JdbcTemplate jdbcTemplate;
    private usuario_mascotaBeanValidation vistaAdopcion;
    public AdopcionDBController(){
        conectarDB con = new conectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.vistaAdopcion = new usuario_mascotaBeanValidation();
    }
    
    @RequestMapping("listaAdopcion")
    public ModelAndView formAdopcion(){
        ModelAndView mav = new ModelAndView();
        String sql = "select * from usuario_mascota";
        List datos = jdbcTemplate.queryForList(sql);
        mav.addObject("adopcion", datos);
        mav.setViewName("views/listaAdopcion");
        return mav;
    }
    
    @RequestMapping(value = "addAdopcion.htm",method = RequestMethod.GET)
    public ModelAndView addAdopcion(){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user = new UsuarioDao();
        List codUsuario = user.ConsultarUsuariosAdopcion();
        mav.addObject("listaUsuarios",codUsuario);
        mascotaDao mascot = new mascotaDao();
        List codMascota = mascot.ConsultarMascotasAdopcion();
        mav.addObject("listaMascotas", codMascota);
        mav.addObject("adopcion", new usuario_mascotaBean());
        mav.setViewName("views/addAdopcion");
        return mav;
    }
    
    @RequestMapping(value = "addAdopcion.htm",method = RequestMethod.POST)
    public ModelAndView addAdopcion(
            @ModelAttribute("adopcion") usuario_mascotaBean per_masform){
            ModelAndView mav = new ModelAndView();
            String sql = "insert into usuario_mascota (id_usuario, id_mascota) "
                + "values (?,?)";
            jdbcTemplate.update(sql, per_masform.getId_usuario(), per_masform.getId_mascota());
            mav.addObject("adopcion", new usuario_mascotaBean());
            mav.setViewName("redirect:/listaAdopcion.htm");
            return mav; 
    }
    
    @RequestMapping("borrarAdopcion.htm")
    public ModelAndView borrarAdopcion(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from usuario_mascota where id = ?";
        this.jdbcTemplate.update(sql,id);
        mav.setViewName("redirect:/listaAdopcion.htm");
        return mav;
    }
    
    @RequestMapping(value = "updateAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView ActualizarAdopcion (HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        usuario_mascotaBean user_masc = consultarAdopcionId (id);
        mav.addObject("adopcion", user_masc);
        UsuarioDao user = new UsuarioDao();
        List codUsuario = user.ConsultarUsuariosAdopcion();
        mav.addObject("listaUsuarios",codUsuario);
        mascotaDao mascot = new mascotaDao();
        List codMascota = mascot.ConsultarMascotasAdopcion();
        mav.addObject("listaMascotas", codMascota);
        mav.setViewName("views/updateAdopcion");
        return mav;
    }
    public usuario_mascotaBean consultarAdopcionId(int id){
        usuario_mascotaBean user_masc = new usuario_mascotaBean();
        String sql = "Select * from usuario_mascota where id = "+ id;
        return (usuario_mascotaBean)jdbcTemplate.query(sql,new ResultSetExtractor<usuario_mascotaBean>(){
            @Override
            public usuario_mascotaBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    user_masc.setId(rs.getInt("id"));
                    user_masc.setId_usuario(rs.getString("id_usuario"));
                    user_masc.setId_mascota(rs.getString("id_mascota"));
                }
                return user_masc;
            }
        });
    }
}
