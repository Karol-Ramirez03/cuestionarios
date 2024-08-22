package com.custionarios.GenerarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerIdOpcionUseCase {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerIdOpcionUseCase(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    public  Optional<List<GenerarCuestionarios>> execute(int id_encuesta,int numero_capitulo, int numero_pregunta, int valor_opcion){
        return generarCuestionariosService.opbteneridopcion(id_encuesta, numero_capitulo, numero_pregunta, valor_opcion);
    }
}
