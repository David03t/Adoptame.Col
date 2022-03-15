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
public class MascotaBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int id;
    private String nombre;
    private String categoria;
    private String raza;
    private String edad;
    private String descripcion;
    private String genero;
    private String foto;

    public MascotaBean() {
    }

    public MascotaBean(int id, String nombre, String categoria, String raza, String edad, String descripcion, String genero, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.raza = raza;
        this.edad = edad;
        this.descripcion = descripcion;
        this.genero = genero;
        this.foto = foto;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

   
}
