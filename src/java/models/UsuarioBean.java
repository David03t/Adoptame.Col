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
public class UsuarioBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int id;
    private String nombrep;
    private String apellidop;
    private String telefonop;
    private String correop;
    private String edadp;
    private String direccionp;
    private String ciudadp;
    private String generop;
    private String foto;
    private String fotoOld;
    private int numero_adopciones;
    

    public UsuarioBean() {
    }

    public UsuarioBean(int id, String nombrep, String apellidop, String telefonop, String correop, String edadp, String direccionp, String ciudadp, String generop, String foto, String fotoOld, int numero_adopciones) {
        this.id = id;
        this.nombrep = nombrep;
        this.apellidop = apellidop;
        this.telefonop = telefonop;
        this.correop = correop;
        this.edadp = edadp;
        this.direccionp = direccionp;
        this.ciudadp = ciudadp;
        this.generop = generop;
        this.foto = foto;
        this.fotoOld = fotoOld;
        this.numero_adopciones = numero_adopciones;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getTelefonop() {
        return telefonop;
    }

    public void setTelefonop(String telefonop) {
        this.telefonop = telefonop;
    }

    public String getCorreop() {
        return correop;
    }

    public void setCorreop(String correop) {
        this.correop = correop;
    }

    public String getEdadp() {
        return edadp;
    }

    public void setEdadp(String edadp) {
        this.edadp = edadp;
    }

    public String getDireccionp() {
        return direccionp;
    }

    public void setDireccionp(String direccionp) {
        this.direccionp = direccionp;
    }

    public String getCiudadp() {
        return ciudadp;
    }

    public void setCiudadp(String ciudadp) {
        this.ciudadp = ciudadp;
    }

    public String getGenerop() {
        return generop;
    }

    public void setGenerop(String generop) {
        this.generop = generop;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoOld() {
        return fotoOld;
    }

    public void setFotoOld(String fotoOld) {
        this.fotoOld = fotoOld;
    }

    public int getNumero_adopciones() {
        return numero_adopciones;
    }

    public void setNumero_adopciones(int numero_adopciones) {
        this.numero_adopciones = numero_adopciones;
    }
    
    
}
