package com.custionarios.preguntas.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.preguntas.domain.entity.Pregunta;


public interface PreguntaService {
    public void CreatePregunta(Pregunta pregunta);
    public void deletePregunta(int id);
    public void updatePregunta(Pregunta pregunta);
    public List<Pregunta> FindAllPregunta();
    public Optional<Pregunta> FindByIdPregunta(int id);

}
