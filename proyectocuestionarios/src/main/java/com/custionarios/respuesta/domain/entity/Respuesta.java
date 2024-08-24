package com.custionarios.respuesta.domain.entity;

public class Respuesta {
    private Integer id;
    private Integer idRespuesta;
    private Integer idSubrespuesta;
    private String textoRespuesta;
    
    public Respuesta(Integer id, Integer idRespuesta, Integer idSubrespuesta, String textoRespuesta) {
        this.id = id;
        this.idRespuesta = idRespuesta;
        this.idSubrespuesta = idSubrespuesta;
        this.textoRespuesta = textoRespuesta;
    }
    

    public Respuesta(Integer idRespuesta, Integer idSubrespuesta, String textoRespuesta) {
        this.idRespuesta = idRespuesta;
        this.idSubrespuesta = idSubrespuesta;
        this.textoRespuesta = textoRespuesta;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdRespuesta() {
        return idRespuesta;
    }
    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    public Integer getIdSubrespuesta() {
        return idSubrespuesta;
    }
    public void setIdSubrespuesta(Integer idSubrespuesta) {
        this.idSubrespuesta = idSubrespuesta;
    }
    public String getTextoRespuesta() {
        return textoRespuesta;
    }
    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }


}
