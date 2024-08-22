package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerSubOpcionesByIdUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerSubOpcionesByIdUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
     public Optional<List<GenerarCuestionarios>> execute(int idopcion ){
        return generarCuestionariosService.obtenerSubOpcionesById(idopcion);
     }
}
