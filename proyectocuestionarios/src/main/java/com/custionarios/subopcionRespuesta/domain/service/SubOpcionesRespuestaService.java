package com.custionarios.subopcionRespuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.subopcionRespuesta.domain.entity.SubopcionesRespuesta;

public interface SubOpcionesRespuestaService {
    public void CreateSubOpcionesRespuesta(SubopcionesRespuesta subOpcionesRespuesta);
    public void deleteSubOpcionesRespuesta(int id);
    public void updateSubOpcionesRespuesta(SubopcionesRespuesta subOpcionesRespuesta);
    public List<SubopcionesRespuesta> FindAllSubOpcionesRespuesta();
    public Optional<SubopcionesRespuesta> FindByIdSubOpcionesRespuesta(int id);
}
