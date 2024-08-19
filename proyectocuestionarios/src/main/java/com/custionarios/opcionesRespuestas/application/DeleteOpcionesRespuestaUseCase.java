package com.custionarios.opcionesRespuestas.application;

import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;

public class DeleteOpcionesRespuestaUseCase {
    private OpcionesRespuestaService opcionesRespuestaService;

    public DeleteOpcionesRespuestaUseCase(OpcionesRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public void execute(int id){
        opcionesRespuestaService.deleteOpcionesRespuesta(id);
    }
}
