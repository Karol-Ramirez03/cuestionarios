package com.custionarios.reportes.infrastructure.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.custionarios.reportes.application.ListarEncuestasUseCase;
import com.custionarios.reportes.domain.entity.Reportes;
import com.custionarios.reportes.domain.service.ReportesService;
import com.custionarios.reportes.infrastructure.ReportesRepository.ReportesRepository;

public class ConsoleAdapterReportes {
    private ReportesService reportesService;
    private ListarEncuestasUseCase listarEncuestas;



    
    public ConsoleAdapterReportes() {
        this.reportesService = new ReportesRepository();
        this.listarEncuestas = new ListarEncuestasUseCase(reportesService);
    }




    public void Start(){
        List<Reportes> listaEncuesta = listarEncuestas.execute();
        StringBuilder st = new StringBuilder();
        for (Reportes reportes : listaEncuesta) {
            int id = reportes.getId();
            String nombre  = reportes.getNombre();

            st.append(id).append(" - ").append(nombre).append("\n");
        }
        JOptionPane.showInputDialog(null, st);
    }
    
}
