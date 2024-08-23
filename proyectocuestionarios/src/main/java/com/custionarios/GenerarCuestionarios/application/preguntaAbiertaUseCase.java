package com.custionarios.GenerarCuestionarios.application;

import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class preguntaAbiertaUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public preguntaAbiertaUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<String> execute(int id){
        return generarCuestionariosService.preguntaabierta(id);
    }

}
