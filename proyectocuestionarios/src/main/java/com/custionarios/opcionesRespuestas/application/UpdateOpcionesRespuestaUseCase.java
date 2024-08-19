package com.custionarios.opcionesRespuestas.application;

import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;
import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;

public class UpdateOpcionesRespuestaUseCase {
    private OpcionesRespuestaService opcionesRespuestaService;

    public UpdateOpcionesRespuestaUseCase(OpcionesRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public void execute(OpcionesRespuesta opcionesRespuesta){
        opcionesRespuestaService.updateOpcionesRespuesta(opcionesRespuesta);
    }
}
