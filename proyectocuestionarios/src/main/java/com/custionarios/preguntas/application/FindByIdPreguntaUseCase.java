package com.custionarios.preguntas.application;

import java.util.Optional;

import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;

public class FindByIdPreguntaUseCase {
    private PreguntaService preguntaService;

    public FindByIdPreguntaUseCase(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }
    
    public Optional<Pregunta> execute(int id){
        return preguntaService.FindByIdPregunta(id);
    }
}
