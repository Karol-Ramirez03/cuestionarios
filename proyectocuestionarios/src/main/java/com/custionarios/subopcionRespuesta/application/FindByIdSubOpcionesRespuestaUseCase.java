package com.custionarios.subopcionRespuesta.application;

import java.util.Optional;

import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class FindByIdSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public FindByIdSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public Optional<SubOpcionesRespuesta> execute(int id){
        return subOpcionesRespuestaService.FindByIdSubOpcionesRespuesta(id);
    }

}
