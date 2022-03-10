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
public class adopcionDao {
    JdbcTemplate jdbcTemplate;
    conectarDB conDB = new conectarDB();
    
    public List ConsultarUsuariosAdopcion(){
        List datos = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql= "Select * from usuario_mascota";
        datos= this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    public List consultarAdopcionById(int id){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select a.id, u.nombrep, m.nombre, a.fecha_de_adopcion from usuario_mascota as a, usuario as u, mascota as m where u.id = a.id_usuario and m.id = a.id_mascota and a.id = ?";
        user = this.jdbcTemplate.queryForList(sql, id);
        return user;
    }
    public List consultarAdopcionByFecha(String fecha){
        List user = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql = "select a.id, u.nombrep, m.nombre, a.fecha_de_adopcion from usuario_mascota as a, usuario as u, mascota as m where u.id = a.id_usuario and m.id = a.id_mascota and a.fecha_de_adopcion = ?";
        user = this.jdbcTemplate.queryForList(sql, fecha);
        return user;
    }
}
