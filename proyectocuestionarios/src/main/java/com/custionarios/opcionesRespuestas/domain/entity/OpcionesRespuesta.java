package com.custionarios.opcionesRespuestas.domain.entity;

import java.sql.Timestamp;

public class OpcionesRespuesta {
   
    private int id;
    private int valorOpcion;
    private int idCategoriaCatalogo;
    private int idPregunta;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private Integer idOpcionPadre; 
    private String tipoComponenteHtml;
    private String comentarioRespuesta;
    private String textoOpcion;

    

    public OpcionesRespuesta(int idCategoriaCatalogo, int idPregunta, Integer idOpcionPadre, String tipoComponenteHtml,
            String comentarioRespuesta, String textoOpcion) {
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.idOpcionPadre = idOpcionPadre;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public OpcionesRespuesta(int valorOpcion, int idCategoriaCatalogo, int idPregunta, Integer idOpcionPadre, String tipoComponenteHtml, String comentarioRespuesta, String textoOpcion) {
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.idOpcionPadre = idOpcionPadre;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public OpcionesRespuesta(int valorOpcion, int idCategoriaCatalogo, int idPregunta, Timestamp creadoEn,
            Timestamp actualizadoEn, String tipoComponenteHtml, String comentarioRespuesta, String textoOpcion) {
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public OpcionesRespuesta(int id, int valorOpcion, int idCategoriaCatalogo, int idPregunta, Timestamp creadoEn,
            Timestamp actualizadoEn, Integer idOpcionPadre, String tipoComponenteHtml, String comentarioRespuesta,
            String textoOpcion) {
        this.id = id;
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.idOpcionPadre = idOpcionPadre;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public int getValorOpcion() {
        return valorOpcion;
    }



    public void setValorOpcion(int valorOpcion) {
        this.valorOpcion = valorOpcion;
    }



    public int getIdCategoriaCatalogo() {
        return idCategoriaCatalogo;
    }



    public void setIdCategoriaCatalogo(int idCategoriaCatalogo) {
        this.idCategoriaCatalogo = idCategoriaCatalogo;
    }



    public int getIdPregunta() {
        return idPregunta;
    }



    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }



    public Timestamp getCreadoEn() {
        return creadoEn;
    }



    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }



    public Timestamp getActualizadoEn() {
        return actualizadoEn;
    }



    public void setActualizadoEn(Timestamp actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public String getTipoComponenteHtml() {
        return tipoComponenteHtml;
    }



    public void setTipoComponenteHtml(String tipoComponenteHtml) {
        this.tipoComponenteHtml = tipoComponenteHtml;
    }



    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }



    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }



    public String getTextoOpcion() {
        return textoOpcion;
    }



    public void setTextoOpcion(String textoOpcion) {
        this.textoOpcion = textoOpcion;
    }



    public Integer getIdOpcionPadre() {
        return idOpcionPadre;
    }



    public void setIdOpcionPadre(Integer idOpcionPadre) {
        this.idOpcionPadre = idOpcionPadre;
    }


    

}
