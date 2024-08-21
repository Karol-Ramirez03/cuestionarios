package com.custionarios.GenerarCuestionarios.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;

public interface GenerarCuestionariosService {
    
    public List<GenerarCuestionarios> mostrar_encuestas();
    public List<GenerarCuestionarios> mostrar_capitulos(int encuesta);
    public List<GenerarCuestionarios> mostrar_preguntas(int capitulo);
    public Optional<List<GenerarCuestionarios>> mostrar_opciones(int pregunta);
    public Optional<List<GenerarCuestionarios>> mostrar_subopciones(int opc);
    // guardar respuesta
}
