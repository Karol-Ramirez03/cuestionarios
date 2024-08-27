package com.custionarios.reportes.domain.service;


import java.util.List;
import java.util.Optional;

import com.custionarios.reportes.domain.entity.Reportes;

public interface ReportesService {
    public List<Reportes> listarEncuestaRespondidas();
    public Optional<List<Reportes>> listarOpcionesysubopciones(int id);
}
