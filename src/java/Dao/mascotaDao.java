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
}
