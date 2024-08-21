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
    public Optional<Integer> mostraopciondelosidpadres(int opc); 
    // la opcion hija esta vinculada a una pregunta que debe ser resuelta para poder ser contestada
    // si la pregunta tiene una opcion padre buscar la opcion juntarla conun join
    // y mostrar el 1 de la pregunta 
    // valor opcion, idcategoriacatalogo, idpregunta,idopcionpadre,textoopcion
    
    public void  guardar_respuesta();
}
