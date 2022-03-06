/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.ejb.Stateless;

/**
 *
 * @author DAVID
 */
@Stateless
public class usuario_mascotaBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private int id;
    private String id_usuario;
    private String id_mascota;
    private String fecha_de_adopcion;

    public usuario_mascotaBean() {
    }

    public usuario_mascotaBean(int id, String id_usuario, String id_mascota, String fecha_de_adopcion) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_mascota = id_mascota;
        this.fecha_de_adopcion = fecha_de_adopcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(String id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getFecha_de_adopcion() {
        return fecha_de_adopcion;
    }

    public void setFecha_de_adopcion(String fecha_de_adopcion) {
        this.fecha_de_adopcion = fecha_de_adopcion;
    }

    

    
}
