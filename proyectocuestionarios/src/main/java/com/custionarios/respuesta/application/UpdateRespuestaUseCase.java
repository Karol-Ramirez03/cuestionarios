package com.custionarios.respuesta.application;

import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;

public class UpdateRespuestaUseCase {
    private RespuestaService respuestaService;

    public UpdateRespuestaUseCase(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(Respuesta respuesta){
        respuestaService.updateRespuesta(respuesta);
    }
}
