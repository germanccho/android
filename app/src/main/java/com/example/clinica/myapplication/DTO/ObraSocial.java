package com.example.clinica.myapplication.DTO;

import java.io.Serializable;

/**
 * Created by Germanccho on 28/8/2017.
 */

public class ObraSocial implements Serializable {
    long id;
    String nombre, direccion, email, cuil, telefono, coseguro, estado;


    public ObraSocial(long id, String nombre, String cuil, String direccion, String telefono, String email,  String estado, String coseguro) {

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.cuil = cuil;
        this.telefono = telefono;
        this.coseguro = coseguro;
        this.estado = estado;
    }

    public ObraSocial(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCoseguro() {
        return coseguro;
    }

    public void setCoseguro(String coseguro) {
        this.coseguro = coseguro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
