/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author SENA
 */
public class conectarDB {
    public DriverManagerDataSource conDB(){
        DriverManagerDataSource dtsource = new DriverManagerDataSource();
        dtsource.setDriverClassName("com.mysql.jdbc.Driver");
        dtsource.setUrl("jdbc:mysql://localhost:3306/adoptame");
        dtsource.setUsername("root");
        dtsource.setPassword("");
        return dtsource;
    }
}
