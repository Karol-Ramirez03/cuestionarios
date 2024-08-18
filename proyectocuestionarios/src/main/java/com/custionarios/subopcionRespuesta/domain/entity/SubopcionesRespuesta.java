package com.custionarios.subopcionRespuesta.domain.entity;

import java.util.Date;

public class SubopcionesRespuesta {
    private int id;
    private int numeroSubopcion;
    private Date creadoEn;
    private Date actualizadoEn;
    private int idOpcionRespuesta;
    private String componenteHtml;
    private String textoSubopcion;

    
    public SubopcionesRespuesta(int id, int numeroSubopcion, Date creadoEn, Date actualizadoEn, int idOpcionRespuesta,
            String componenteHtml, String textoSubopcion) {
        this.id = id;
        this.numeroSubopcion = numeroSubopcion;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.idOpcionRespuesta = idOpcionRespuesta;
        this.componenteHtml = componenteHtml;
        this.textoSubopcion = textoSubopcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getNumeroSubopcion() {
        return numeroSubopcion;
    }


    public void setNumeroSubopcion(int numeroSubopcion) {
        this.numeroSubopcion = numeroSubopcion;
    }


    public Date getCreadoEn() {
        return creadoEn;
    }


    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }


    public Date getActualizadoEn() {
        return actualizadoEn;
    }


    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }


    public int getIdOpcionRespuesta() {
        return idOpcionRespuesta;
    }


    public void setIdOpcionRespuesta(int idOpcionRespuesta) {
        this.idOpcionRespuesta = idOpcionRespuesta;
    }


    public String getComponenteHtml() {
        return componenteHtml;
    }


    public void setComponenteHtml(String componenteHtml) {
        this.componenteHtml = componenteHtml;
    }


    public String getTextoSubopcion() {
        return textoSubopcion;
    }


    public void setTextoSubopcion(String textoSubopcion) {
        this.textoSubopcion = textoSubopcion;
    }

    

}
