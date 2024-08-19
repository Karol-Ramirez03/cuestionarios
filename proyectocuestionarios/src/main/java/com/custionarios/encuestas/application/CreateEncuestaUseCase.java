package com.custionarios.encuestas.application;

import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;

public class CreateEncuestaUseCase {
    private EncuestaService encuestaService;

    public CreateEncuestaUseCase(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(Encuesta encuesta){
        encuestaService.CreateEncuesta(encuesta);
    }
    
}
