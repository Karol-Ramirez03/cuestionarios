package com.custionarios.GenerarCuestionarios.application;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class RetornarIdSubOpcionPorValorUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public RetornarIdSubOpcionPorValorUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public int execute(int idOpcion, int valorSub){
        return generarCuestionariosService.retornaridSubOpcionPorvalor(idOpcion, valorSub);
    }
}
