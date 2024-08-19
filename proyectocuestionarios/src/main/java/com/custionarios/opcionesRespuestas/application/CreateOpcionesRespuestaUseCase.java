package com.custionarios.opcionesRespuestas.application;

import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;
import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;

public class CreateOpcionesRespuestaUseCase {
    private OpcionesRespuestaService opcionesRespuestaService;

    public CreateOpcionesRespuestaUseCase(OpcionesRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public void execute(OpcionesRespuesta opcionesRespuesta){
        opcionesRespuestaService.CreateOpcionesRespuesta(opcionesRespuesta);
    }

}
