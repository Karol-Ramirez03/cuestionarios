package com.custionarios.GenerarCuestionarios.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;

public interface GenerarCuestionariosService {
    
    public List<GenerarCuestionarios> mostrar_encuestas();
    public List<GenerarCuestionarios> mostrar_capitulos(int encuesta);
    public Optional<List<GenerarCuestionarios>> mostrar_preguntas(int numcapitulo, int idencuesta);
    public Optional<List<GenerarCuestionarios>> mostrar_opciones(int numpregunta,int numCap, int idEncuesta);
    public Optional<List<GenerarCuestionarios>> mostrar_subopciones(int opc);
    public Optional<Integer> mostraopciondelosidpadres(int numpregunta,int numCap, int idEncuesta); 

    public  Optional<List<GenerarCuestionarios>> mostrarpreguntaporId(int id);

    public Optional<List<GenerarCuestionarios>> opbteneridopcion(int id_encuesta,int numero_capitulo, int numero_pregunta, int valor_opcion);
    public Optional<List<GenerarCuestionarios>> obtenerPreguntaHija(int idopcion);
    public Optional<List<GenerarCuestionarios>> obtenerOpcionesById(int idpregunta);
    public Optional<Integer>  obtenerIdOpcionByvalor(int idpregunta, int valor_opcion);
    public Optional<List<GenerarCuestionarios>> obtenerSubOpcionesById(int idopcion);
    public void  guardar_respuesta();
}
