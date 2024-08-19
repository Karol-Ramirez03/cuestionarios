package com.custionarios.opcionesRespuestas.application;

import java.util.List;

import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;
import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;

public class FindAllOpcionesRespuestaUseCase {
    private OpcionesRespuestaService opcionesRespuestaService;

    public FindAllOpcionesRespuestaUseCase(OpcionesRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public List<OpcionesRespuesta> execute(){
        return opcionesRespuestaService.FindAllOpcionesRespuesta(); 
    }
}
