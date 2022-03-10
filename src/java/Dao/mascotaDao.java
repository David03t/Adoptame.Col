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
public class mascotaDao {
    JdbcTemplate jdbcTemplate;
    conectarDB conDB = new conectarDB();
    
    public List ConsultarMascotasAdopcion(){
        List datos = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(conDB.conDB());
        String sql= "Select * from mascota";
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
}
