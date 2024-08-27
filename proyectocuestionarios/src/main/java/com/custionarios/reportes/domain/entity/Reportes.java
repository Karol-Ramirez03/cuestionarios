package com.custionarios.reportes.domain.entity;

public class Reportes {
    private int id;
    private String nombre;

    private String pregunta;
    private String taxto_opcion;
    private int cantidad_opcion;
    private String texto_subopcion;
    private int cantidad_subopcion;
    private String texto;
    
    
    public Reportes(String pregunta, String taxto_opcion, int cantidad_opcion, String texto_subopcion,
            int cantidad_subopcion, String texto) {
        this.pregunta = pregunta;
        this.taxto_opcion = taxto_opcion;
        this.cantidad_opcion = cantidad_opcion;
        this.texto_subopcion = texto_subopcion;
        this.cantidad_subopcion = cantidad_subopcion;
        this.texto = texto;
    }

    public Reportes(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTaxto_opcion() {
        return taxto_opcion;
    }

    public void setTaxto_opcion(String taxto_opcion) {
        this.taxto_opcion = taxto_opcion;
    }

    public int getCantidad_opcion() {
        return cantidad_opcion;
    }

    public void setCantidad_opcion(int cantidad_opcion) {
        this.cantidad_opcion = cantidad_opcion;
    }

    public String getTexto_subopcion() {
        return texto_subopcion;
    }

    public void setTexto_subopcion(String texto_subopcion) {
        this.texto_subopcion = texto_subopcion;
    }

    public int getCantidad_subopcion() {
        return cantidad_subopcion;
    }

    public void setCantidad_subopcion(int cantidad_subopcion) {
        this.cantidad_subopcion = cantidad_subopcion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
