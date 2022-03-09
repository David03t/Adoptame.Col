/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.UsuarioDao;
import Dao.conectarDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import models.usuario_mascotaBean;
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


    
         @RequestMapping(value = "addPersonas.htm",method = RequestMethod.POST)
    public ModelAndView AddUsuarios ( 
            @ModelAttribute("persona") UsuarioBean perform,
            BindingResult result,
            SessionStatus status){
        this.vistapersonas.validate(perform, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("personas", new UsuarioBean());
            mav.setViewName("views/addPersonas");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            String sql = "insert into usuario (nombrep, apellidop, telefonop, correop, edadp, direccionp, ciudadp, generop) "
                + "values (?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, perform.getNombrep(), perform.getApellidop(), perform.getTelefonop(), perform.getCorreop(),perform.getEdadp(), perform.getDireccionp(), perform.getCiudadp(), perform.getGenerop());
            mav.addObject("persona", new UsuarioBean());
            mav.setViewName("redirect:/listaPersonas.htm");
            return mav;
        } 
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
        @ModelAttribute ("persona") usuario_mascotaBean per_mas,
        BindingResult result,
        SessionStatus status){
        ModelAndView mav = new ModelAndView();
        UsuarioDao user= new UsuarioDao();
        int id = per_mas.getId();
        mav.addObject("persona", user.consultarUsuariosById(id)); 
        mav.setViewName ("views/vistaConsultaPersonaId");
        return mav;
    }
}
