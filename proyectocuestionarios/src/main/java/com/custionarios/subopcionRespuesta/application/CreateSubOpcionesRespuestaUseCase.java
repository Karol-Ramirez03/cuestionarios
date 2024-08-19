package com.custionarios.subopcionRespuesta.application;

import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class CreateSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public CreateSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(SubOpcionesRespuesta subOpcionesRespuesta){
        subOpcionesRespuestaService.CreateSubOpcionesRespuesta(subOpcionesRespuesta);

    }

}
