package com.custionarios.respuesta.application;

import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;

public class CreateRespuestaUseCase {
    private RespuestaService respuestaService;

    public CreateRespuestaUseCase(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(Respuesta respuesta) {
        respuestaService.CreateRespuesta(respuesta);
    }
    

}
