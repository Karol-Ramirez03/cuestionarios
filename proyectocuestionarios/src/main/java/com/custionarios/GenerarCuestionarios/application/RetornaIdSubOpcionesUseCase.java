package com.custionarios.GenerarCuestionarios.application;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class RetornaIdSubOpcionesUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public RetornaIdSubOpcionesUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public int execute(int idEncuesta, int numCap,int numPreg,int valorOpc,int numSubOpcion) {
     return generarCuestionariosService.retornaridSubOpcion(idEncuesta, numCap, numPreg, valorOpc, numSubOpcion);
    }
    
}
