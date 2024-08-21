package com.custionarios.GenerarCuestionarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.application.MostrarCapitulosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarCuestionariosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarPreguntasUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarSubOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;
import com.custionarios.GenerarCuestionarios.infrastructure.repository.GenerarCuestionariosRepository;



public class ConsoleAdapterGenerarCuestionarios {
    private GenerarCuestionariosService generarCuestionariosService;
    private MostrarCuestionariosUseCase mostrar;
    private MostrarCapitulosUseCase mostrarCap;
    private MostrarPreguntasUseCase mostrarPreg;
    private MostrarOpcionesUseCase mostrarOpc;
    private MostrarSubOpcionesUseCase mostrarSub;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
        this.mostrarPreg = new MostrarPreguntasUseCase(generarCuestionariosService);
        this.mostrarOpc = new MostrarOpcionesUseCase(generarCuestionariosService);
        this.mostrarSub = new MostrarSubOpcionesUseCase(generarCuestionariosService);
    }



    public void Start(){
        List<GenerarCuestionarios> encuesta = mostrar.execute();
        StringBuilder sb = new StringBuilder();
        // visualizar encuesta
        for (GenerarCuestionarios cuestionario : encuesta) {
            String nombre = cuestionario.getNombre();
            int id = cuestionario.getIndice();

            sb.append(id).append(" - ").append(nombre).append("\n");   
        }
        try {
            int num = Integer.parseInt(JOptionPane.showInputDialog(null,sb));
            // el numero es el id del cuestionario

            List<GenerarCuestionarios> capitulos = mostrarCap.execute(num);
            //muestra los capitulos relacionados a la encuesta
            System.out.println(num);
            StringBuilder capi = new StringBuilder();
            for (GenerarCuestionarios cap : capitulos) {
                int id = cap.getIndice();
                String nombre = cap.getNombre();

                capi.append(id).append(" - ").append(nombre).append("\n");   
            }
            try {

                int numcap = Integer.parseInt(JOptionPane.showInputDialog(null, capi));
                // seleciona el id del capitulo al que estan relacionadas las preguntas
                StringBuilder preg = new StringBuilder();
                List<GenerarCuestionarios> preguntas = mostrarPreg.execute(numcap);

                for (GenerarCuestionarios cap : preguntas) {
                    int id = cap.getIndice();
                    String nombre = cap.getNombre();

                    preg.append(id).append(" - ").append(nombre).append("\n");   
                }
                try {
                    System.out.println("validar");
                    int numPreg =  Integer.parseInt(JOptionPane.showInputDialog(null, preg));
                    // selecciona el id de la pregunta
                    StringBuilder opc = new StringBuilder();
                    Optional<List<GenerarCuestionarios>> opciones = mostrarOpc.execute(numPreg);
                    // mostrar opciones relacionadas a la pregunta 
                    
                    if (opciones.isPresent()) {
                        List<GenerarCuestionarios> listOpciones = opciones.get();
                        for (GenerarCuestionarios opcion : listOpciones) {
                            int idopc = opcion.getIndice();
                            String nombreopc = opcion.getNombre();

                            opc.append(idopc).append(" - ").append(nombreopc.toString()).append("\n"); 
                        }
                        try {
                            int numOpc = Integer.parseInt(JOptionPane.showInputDialog(null,opc));
                            //aqui buscamos si tiene relacionado subopciones
                            Optional<List<GenerarCuestionarios>> subOpciones = mostrarSub.execute(numOpc);
                            StringBuilder sub = new StringBuilder();
                            if (subOpciones.isPresent()) {
                                List<GenerarCuestionarios> datos = subOpciones.get();
                                for (GenerarCuestionarios dato : datos) {
                                    int numero = dato.getIndice();
                                    String informacion = dato.getNombre();

                                    sub.append(numero).append(" - ").append(informacion).append("\n"); ;
                                }
                                try {
                                    int numsub = Integer.parseInt(JOptionPane.showInputDialog(null,sub));
                                    
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
                                    Start();
                                }
                            } else {
                                
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
                            Start();
                        }
                    } else {
                        System.out.println("chao");
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
                    Start();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
                Start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
            Start();
        }
        


    }

    
    
}
