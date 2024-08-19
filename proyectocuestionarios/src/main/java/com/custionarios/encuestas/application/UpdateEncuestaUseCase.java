package com.custionarios.encuestas.application;

import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;

public class UpdateEncuestaUseCase {
    private EncuestaService encuestaService;

    public UpdateEncuestaUseCase(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(Encuesta encuesta){
        encuestaService.updateEncuesta(encuesta);
    }
}
