package com.custionarios.GenerarCuestionarios.application;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaOpcionUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaOpcionUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public void execute(int idOpcion){
        generarCuestionariosService.guardar_respuestaOpcion(idOpcion);
    }

}
