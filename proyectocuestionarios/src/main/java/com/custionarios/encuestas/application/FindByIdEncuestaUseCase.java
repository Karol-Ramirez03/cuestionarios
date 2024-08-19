package com.custionarios.encuestas.application;

import java.util.Optional;

import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;

public class FindByIdEncuestaUseCase {
    private EncuestaService encuestaService;

    public FindByIdEncuestaUseCase(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public Optional<Encuesta> execute(int id){
        return encuestaService.FindByIdEncuesta(id);
    }
}
