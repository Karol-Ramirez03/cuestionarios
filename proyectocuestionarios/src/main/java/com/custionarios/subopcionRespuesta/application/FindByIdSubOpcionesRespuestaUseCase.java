package com.custionarios.subopcionRespuesta.application;

import java.util.Optional;

import com.custionarios.subopcionRespuesta.domain.entity.SubopcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class FindByIdSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public FindByIdSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public Optional<SubopcionesRespuesta> execute(int id){
        return subOpcionesRespuestaService.FindByIdSubOpcionesRespuesta(id);
    }

}
