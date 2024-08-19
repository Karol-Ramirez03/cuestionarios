package com.custionarios.encuestas.application;

import com.custionarios.encuestas.domain.service.EncuestaService;

public class DeleteEncuestaUseCase {
    private EncuestaService encuestaService;

    public DeleteEncuestaUseCase(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(int id){
        encuestaService.deleteEncuesta(id);
    }
}
