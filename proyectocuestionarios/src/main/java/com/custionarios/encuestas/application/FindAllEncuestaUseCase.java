package com.custionarios.encuestas.application;

import java.util.List;

import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;

public class FindAllEncuestaUseCase {
    private EncuestaService encuestaService;

    public FindAllEncuestaUseCase(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public List<Encuesta> execute(){
        return encuestaService.FindAllEncuesta();
    }
}
