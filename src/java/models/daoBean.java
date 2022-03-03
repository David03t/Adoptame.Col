/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.ejb.Stateless;

/**
 *
 * @author DAVID
 */
@Stateless
public class daoBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static Connection conecta(){
        Connection conecta = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String server = "jdbc:mysql://localhost/adoptame";
            String user = "root";
            String pass="";
            conecta = (Connection)DriverManager.getConnection(server,user,pass);
        }
    
    catch(ClassNotFoundException ex){
        System.out.println(ex.getMessage());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    finally{
        return conecta;
    }
    }
}
