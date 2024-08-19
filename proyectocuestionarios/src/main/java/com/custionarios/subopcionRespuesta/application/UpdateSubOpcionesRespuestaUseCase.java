package com.custionarios.subopcionRespuesta.application;

import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class UpdateSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public UpdateSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(SubOpcionesRespuesta subOpcionesRespuesta){
        subOpcionesRespuestaService.updateSubOpcionesRespuesta(subOpcionesRespuesta);
    }

}
