package com.custionarios.GenerarCuestionarios.infrastructure.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.application.MostrarCapitulosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarCuestionariosUseCase;
import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;
import com.custionarios.GenerarCuestionarios.infrastructure.repository.GenerarCuestionariosRepository;


public class ConsoleAdapterGenerarCuestionarios {
    private GenerarCuestionariosService generarCuestionariosService;
    private MostrarCuestionariosUseCase mostrar;
    private MostrarCapitulosUseCase mostrarCap;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
    }



    public void Start(){
        List<GenerarCuestionarios> encuesta = mostrar.execute();
        StringBuilder sb = new StringBuilder();
        for (GenerarCuestionarios cuestionario : encuesta) {
            String nombre = cuestionario.getNombre();
            int id = cuestionario.getIndice();

            sb.append(id).append(" - ").append(nombre).append("\n");   
        }
        try {
            int num = Integer.parseInt(JOptionPane.showInputDialog(null, sb));
            List<GenerarCuestionarios> capitulos = mostrarCap.execute(num);
            StringBuilder capi = new StringBuilder();
            for (GenerarCuestionarios cap : capitulos) {
                int id = cap.getIndice();
                String nombre = cap.getNombre();

                capi.append(id).append(" - ").append(nombre).append("\n");   
            }
            try {
                int numcap = Integer.parseInt(JOptionPane.showInputDialog(null, capi));
                
            } catch (Exception e) {
                Start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
            Start();
        }
        
        


    }

    
    
}
