/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

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
        String sql= "Select * from usuario";
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
}
