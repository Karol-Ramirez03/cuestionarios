package com.custionarios.reportes.application;

import java.util.List;
import java.util.Optional;

import com.custionarios.reportes.domain.entity.Reportes;
import com.custionarios.reportes.domain.service.ReportesService;

public class MostrarOpcionesSubopcionesUseCase {
    private ReportesService reportesService;

    public MostrarOpcionesSubopcionesUseCase(ReportesService reportesService) {
        this.reportesService = reportesService;
    }

    public Optional<List<Reportes>> execute(int id){
        return reportesService.listarOpcionesysubopciones(id);
    }
}
