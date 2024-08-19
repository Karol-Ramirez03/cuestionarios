package com.custionarios.preguntas.application;

import com.custionarios.preguntas.domain.service.PreguntaService;

public class DeletePreguntaUseCase {
    private PreguntaService preguntaService;

    public DeletePreguntaUseCase(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    public void execute(int id){
        preguntaService.deletePregunta(id);
    }
}
