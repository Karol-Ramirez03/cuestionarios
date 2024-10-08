package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntasUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntasUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<List<GenerarCuestionarios>> execute(int numcapitulo, int idencuesta){
        return generarCuestionariosService.mostrar_preguntas(numcapitulo,idencuesta);
    }
}
