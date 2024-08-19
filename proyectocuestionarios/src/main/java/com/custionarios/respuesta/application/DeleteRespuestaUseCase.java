package com.custionarios.respuesta.application;

import com.custionarios.respuesta.domain.service.RespuestaService;

public class DeleteRespuestaUseCase {
    private RespuestaService respuestaService;

    public DeleteRespuestaUseCase(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(int id) {
        respuestaService.deleteRespuesta(id);
    }
}
