package com.custionarios.GenerarCuestionarios.application;

import java.util.List;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarCuestionariosUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarCuestionariosUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(){
        return generarCuestionariosService.mostrar_encuestas();
    }

}
