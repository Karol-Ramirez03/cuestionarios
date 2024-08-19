package com.custionarios.preguntas.application;

import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;

public class CreatePreguntaUseCase {
    private PreguntaService preguntaService;

    public CreatePreguntaUseCase(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }
    
    public void execute(Pregunta pregunta){
        preguntaService.CreatePregunta(pregunta);
    }

}
