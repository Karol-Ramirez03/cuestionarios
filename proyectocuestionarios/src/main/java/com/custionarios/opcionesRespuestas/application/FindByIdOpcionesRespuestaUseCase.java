package com.custionarios.opcionesRespuestas.application;

import java.util.Optional;

import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;
import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;

public class FindByIdOpcionesRespuestaUseCase {
    private OpcionesRespuestaService opcionesRespuestaService;

    public FindByIdOpcionesRespuestaUseCase(OpcionesRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public Optional<OpcionesRespuesta> execute(int id){
        return opcionesRespuestaService.FindByIdOpcionesRespuesta(id);
    }
}
