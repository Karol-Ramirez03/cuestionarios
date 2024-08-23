package com.custionarios.GenerarCuestionarios.application;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaSubOpcionUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaSubOpcionUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public void execute(int idSubopcion){
        generarCuestionariosService.guardar_respuestaSubOpcion(idSubopcion);
    }

}
