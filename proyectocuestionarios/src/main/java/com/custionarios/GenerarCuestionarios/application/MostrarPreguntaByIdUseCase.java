package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntaByIdUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntaByIdUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public  Optional<List<GenerarCuestionarios>> execute(int id){
        return generarCuestionariosService.mostrarpreguntaporId(id);
    }

}
