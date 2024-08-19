package com.custionarios.preguntas.application;

import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;

public class UpdatePreguntaUseCase {
    private PreguntaService preguntaService;

    public UpdatePreguntaUseCase(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    public void execute(Pregunta pregunta){
        preguntaService.updatePregunta(pregunta);
    }
}
