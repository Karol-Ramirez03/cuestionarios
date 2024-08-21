package com.custionarios.GenerarCuestionarios.domain.service;

import java.util.List;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;

public interface GenerarCuestionariosService {
    
    public List<GenerarCuestionarios> mostrar_encuestas();
    public List<GenerarCuestionarios> mostrar_capitulos(int encuesta);
    // mostrar preguntas 
    // mostrar opciones
    // mostrar subopciones
    // guardar respuesta
}
