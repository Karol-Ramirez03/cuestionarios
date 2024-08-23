package com.custionarios.GenerarCuestionarios.application;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaOpcionAbiertaUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaOpcionAbiertaUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public void execute(int idopcionAbierta,String respuestaAbierta) {
        generarCuestionariosService.guardar_respuestaOpcionAbierta(idopcionAbierta,respuestaAbierta);
    }

}
