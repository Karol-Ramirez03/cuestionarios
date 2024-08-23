package com.custionarios.GenerarCuestionarios.application;

import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerIdOpcionByValorUseCase {
     private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerIdOpcionByValorUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<Integer>  execute(int idpregunta, int valor_opcion){
        return generarCuestionariosService.obtenerIdOpcionByvalor(idpregunta, valor_opcion);
     }
}
