package com.custionarios.GenerarCuestionarios.application;

import java.util.List;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarCapitulosUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarCapitulosUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(int encuestaid){
        return generarCuestionariosService.mostrar_capitulos(encuestaid);
    }
}
