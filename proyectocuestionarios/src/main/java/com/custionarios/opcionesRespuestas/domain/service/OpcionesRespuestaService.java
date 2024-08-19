package com.custionarios.opcionesRespuestas.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;


public interface OpcionesRespuestaService {
    public void CreateOpcionesRespuesta(OpcionesRespuesta opcionesRespuesta);
    public void deleteOpcionesRespuesta(int id);
    public void updateOpcionesRespuesta(OpcionesRespuesta opcionesRespuesta);
    public List<OpcionesRespuesta> FindAllOpcionesRespuesta();
    public Optional<OpcionesRespuesta> FindByIdOpcionesRespuesta(int id);

}
