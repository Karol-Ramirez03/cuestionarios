package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarSubOpcionesUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarSubOpcionesUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public Optional<List<GenerarCuestionarios>> execute(int idEncuesta,int numCapitulo, int numPreg, int valorOpc){
        return generarCuestionariosService.mostrar_subopciones(idEncuesta,numCapitulo,numPreg,valorOpc);
    }

}
