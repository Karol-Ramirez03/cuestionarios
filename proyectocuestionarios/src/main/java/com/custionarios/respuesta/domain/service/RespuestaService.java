package com.custionarios.respuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.respuesta.domain.entity.Respuesta;

public interface RespuestaService {
    public void CreateRespuesta(Respuesta respuesta);
    public void deleteRespuesta(int id);
    public void updateRespuesta(Respuesta respuesta);
    public List<Respuesta> FindAllRespuesta();
    public Optional<Respuesta> FindByIdRespuesta(int id);

}
