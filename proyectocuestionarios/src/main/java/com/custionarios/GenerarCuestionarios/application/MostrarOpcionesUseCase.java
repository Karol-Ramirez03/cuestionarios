package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarOpcionesUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarOpcionesUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<List<GenerarCuestionarios>> execute(int preguntaid){
        return generarCuestionariosService.mostrar_opciones(preguntaid);
    }
}
