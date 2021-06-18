package com.example.reestructurarutas.pojo;

public class servicio {

    String id, medidor, rpu, cuenta, nombre, direccion, georeferencia, observaciones;

    public servicio() {
    }


    public servicio(String id, String medidor, String rpu, String cuenta, String nombre, String direccion, String georeferencia, String observaciones) {
        this.id = id;
        this.medidor = medidor;
        this.rpu = rpu;
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.georeferencia = georeferencia;
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public String getRpu() {
        return rpu;
    }

    public void setRpu(String rpu) {
        this.rpu = rpu;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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

    public String getGeoreferencia() {
        return georeferencia;
    }

    public void setGeoreferencia(String georeferencia) {
        this.georeferencia = georeferencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}