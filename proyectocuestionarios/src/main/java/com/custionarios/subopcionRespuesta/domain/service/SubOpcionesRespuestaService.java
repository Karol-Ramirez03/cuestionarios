package com.custionarios.subopcionRespuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;

public interface SubOpcionesRespuestaService {
    public void CreateSubOpcionesRespuesta(SubOpcionesRespuesta subOpcionesRespuesta);
    public void deleteSubOpcionesRespuesta(int id);
    public void updateSubOpcionesRespuesta(SubOpcionesRespuesta subOpcionesRespuesta);
    public List<SubOpcionesRespuesta> FindAllSubOpcionesRespuesta();
    public Optional<SubOpcionesRespuesta> FindByIdSubOpcionesRespuesta(int id);
}
