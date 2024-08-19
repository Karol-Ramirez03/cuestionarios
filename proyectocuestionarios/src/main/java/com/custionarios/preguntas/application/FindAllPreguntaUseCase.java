package com.custionarios.preguntas.application;

import java.util.List;

import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;

public class FindAllPreguntaUseCase {
    private PreguntaService preguntaService;

    public FindAllPreguntaUseCase(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    public List<Pregunta> execute(){
        return preguntaService.FindAllPregunta();
    }
}
