package com.custionarios.GenerarCuestionarios.application;

import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostraropcionidpadreUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostraropcionidpadreUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<Integer>  execute(int opc){
        return generarCuestionariosService.mostraopciondelosidpadres(opc);
    }
}


