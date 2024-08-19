package com.custionarios.respuesta.application;

import java.util.Optional;

import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;

public class FindByIdRespuestaUseCase {
    private RespuestaService respuestaService;

    public FindByIdRespuestaUseCase(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public Optional<Respuesta> execute(int id) {
        return respuestaService.FindByIdRespuesta(id);
    }
}
