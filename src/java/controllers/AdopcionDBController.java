/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.conectarDB;
import java.util.List;
import models.usuario_mascotaBeanValidation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
