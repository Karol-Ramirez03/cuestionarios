package com.custionarios.GenerarCuestionarios.application;

import java.util.List;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntasUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntasUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(int capitulo){
        return generarCuestionariosService.mostrar_preguntas(capitulo);
    }
}
