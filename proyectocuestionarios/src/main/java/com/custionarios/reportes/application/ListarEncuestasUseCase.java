package com.custionarios.reportes.application;


import java.util.List;

import com.custionarios.reportes.domain.entity.Reportes;
import com.custionarios.reportes.domain.service.ReportesService;

public class ListarEncuestasUseCase {
    private ReportesService reportesService;

    public ListarEncuestasUseCase(ReportesService reportesService) {
        this.reportesService = reportesService;
    }

    public List<Reportes> execute(){
        return reportesService.listarEncuestaRespondidas();
    }
}
