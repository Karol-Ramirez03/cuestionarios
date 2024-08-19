package com.custionarios.subopcionRespuesta.application;

import java.util.List;

import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class FindAllSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public FindAllSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    
    public List<SubOpcionesRespuesta> execute(){
        return subOpcionesRespuestaService.FindAllSubOpcionesRespuesta();
    }
}
