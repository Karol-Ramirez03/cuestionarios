package com.custionarios.GenerarCuestionarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.application.MostrarCapitulosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarCuestionariosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarPreguntasUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarSubOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.MostraropcionidpadreUseCase;
import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;
import com.custionarios.GenerarCuestionarios.infrastructure.repository.GenerarCuestionariosRepository;

// ingresa cuestionario
/**
 * ingresa capitulo 
 * seleciona pregunta 
 * if retorna id de la pregunta 
 * con la funcion mostrar pregunta pasa el id y muestra la pregunta para contestarla 
 * la siguiente automaticamente mostrar pregunta de seleccion pregunta
 * sus opciones 
 * y si no responde pregunta a normal
 * mostra pregunta 
 * sus opciones y subopciones
 */

public class ConsoleAdapterGenerarCuestionarios {
    private GenerarCuestionariosService generarCuestionariosService;
    private MostrarCuestionariosUseCase mostrar;
    private MostrarCapitulosUseCase mostrarCap;
    private MostrarPreguntasUseCase mostrarPreg;
    private MostrarOpcionesUseCase mostrarOpc;
    private MostrarSubOpcionesUseCase mostrarSub;
    private MostraropcionidpadreUseCase mostraridpadre;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
        this.mostrarPreg = new MostrarPreguntasUseCase(generarCuestionariosService);
        this.mostrarOpc = new MostrarOpcionesUseCase(generarCuestionariosService);
        this.mostrarSub = new MostrarSubOpcionesUseCase(generarCuestionariosService);
        this.mostraridpadre = new MostraropcionidpadreUseCase(generarCuestionariosService);
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
       
            String  num = JOptionPane.showInputDialog(null,sb);
            // el numero es el id del cuestionario
            if (num == null) {
                return;
            } else{
                try {
                    int numero = Integer.parseInt(num);
                    List<GenerarCuestionarios> capitulos = mostrarCap.execute(numero);
                    //muestra los capitulos relacionados a la encuesta
                    StringBuilder capi = new StringBuilder();
    
    
                    for (GenerarCuestionarios cap : capitulos) {
                        int id = cap.getIndice();
                        String nombre = cap.getNombre();
    
                        capi.append(id).append(" - ").append(nombre).append("\n");   
                    }
                    try {

                        String numpCAP = JOptionPane.showInputDialog(null, capi);
                        if (numpCAP == null) {
                            return;
                            
                        } else {
                            int numeroCap = Integer.parseInt(numpCAP);
                            // seleciona el id del capitulo al que estan relacionadas las preguntas
                            StringBuilder preg = new StringBuilder();
                            List<GenerarCuestionarios> preguntas = mostrarPreg.execute(numeroCap);
                            for (GenerarCuestionarios cap : preguntas) {
                                int id = cap.getIndice();
                                String nombre = cap.getNombre();
            
                                preg.append(id).append(" - ").append(nombre).append("\n");   
                            }
                            String numero_pregunta= JOptionPane.showInputDialog(null, preg);
                            if (numero_pregunta == null) {
                                return;
                            } else {
                                try {
                                    int pregnum = Integer.parseInt(numero_pregunta);
                                    Optional<Integer> numPregPrimero = mostraridpadre.execute(pregnum);
                                    if (numPregPrimero.isPresent()) {
                                        int preguntaPrimero = numPregPrimero.get();
                                        mostrarPreg.execute(preguntaPrimero);


                                        //opcion guardar
                                        mostrarPreg.execute(pregnum);
                                        //opcion guardar 
                                    } else {
                                        mostrarPreg.execute(pregnum);
                                        
                                        //opcion guardar
                                    }

                                } catch (Exception e) {
                                    // TODO: handle exception
                                }
                                
                            }
                            
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

           
            System.out.println(num);
            
                
           
        } 
    

 }

    
    

