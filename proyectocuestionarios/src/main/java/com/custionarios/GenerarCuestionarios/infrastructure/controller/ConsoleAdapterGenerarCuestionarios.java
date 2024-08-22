package com.custionarios.GenerarCuestionarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.application.MostrarCapitulosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarCuestionariosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarPreguntaByIdUseCase;
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
    private MostrarPreguntaByIdUseCase mostrarPregID;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
        this.mostrarPreg = new MostrarPreguntasUseCase(generarCuestionariosService);
        this.mostrarOpc = new MostrarOpcionesUseCase(generarCuestionariosService);
        this.mostrarSub = new MostrarSubOpcionesUseCase(generarCuestionariosService);
        this.mostraridpadre = new MostraropcionidpadreUseCase(generarCuestionariosService);
        this.mostrarPregID = new MostrarPreguntaByIdUseCase(generarCuestionariosService);
    }

    public int validarnumeros(int numeromax, String opcionelegida) {
        if (opcionelegida == null || opcionelegida.isEmpty()) {
            return 0;
        }
    
        try {
            int opcion = Integer.parseInt(opcionelegida);
            if (opcion <= 0 || opcion > numeromax) {
                JOptionPane.showMessageDialog(null, "Opción fuera de rango. Por favor, selecciona una opción válida.");
                Start(); 
                return -1;
            }
            if (opcion == numeromax) {
                return 0; 
            }
            return opcion; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, introduce un número.");
            Start(); 
            return -1;
        }
    }
    // me retorna -1 o 0 si se presenta comflicto con la entrada y sale de ejecucion

    public int imprimircuestionarios(){
        StringBuilder st = new StringBuilder();
        List<GenerarCuestionarios> cuetionarios = mostrar.execute();
        for (GenerarCuestionarios cuestionario : cuetionarios) {
            st.append(cuestionario.getIndice()).append(" - ").append(cuestionario.getNombre()).append("\n");
        }
        st.append(cuetionarios.size()+1).append(" - ").append("salir");
        String data = JOptionPane.showInputDialog(null,st);
        int numero = validarnumeros(cuetionarios.size()+1, data);
        
        return numero; 
    }
    // me retorna el id del cuestionario

    public int imprimircapitulos(int numencuesta){
        StringBuilder st = new StringBuilder();
        List<GenerarCuestionarios> capitulos = mostrarCap.execute(numencuesta);
        for (GenerarCuestionarios cap : capitulos) {
            st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
        }
        st.append(capitulos.size()+1).append(" - ").append("salir");
        String data = JOptionPane.showInputDialog(null,st);
        int numero = validarnumeros(capitulos.size()+1, data);
        return numero;

    }
    // me retorna el numero de capitulo

    public int imprimirpreguntas(int numcapitulo, int idencuesta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> capitulos = mostrarPreg.execute(numcapitulo,idencuesta);
        if (capitulos.isPresent()) {
            List<GenerarCuestionarios> capit = capitulos.get();
            for (GenerarCuestionarios cap : capit) {
                st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
            }
            st.append(capit.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(capit.size()+1, data);
            return numero;
            
        }
        return 0;
    }
    //me retorna el numero de la pregunta

            //numvalorOpcion
    public int imprimiropciones(int numpregunta,int numCap, int idEncuesta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> opciones = mostrarOpc.execute(numpregunta, numCap, idEncuesta);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return numero;
            
        }
        return 1;
    }
    //me retorna el valor de la opcion

    public int imprimirpreguntaid(int id){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> capitulos = mostrarPregID.execute(id);
        if (capitulos.isPresent()) {
            List<GenerarCuestionarios> capit = capitulos.get();
            for (GenerarCuestionarios cap : capit) {
                st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
            }
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(capit.size()+1, data);
            return numero;
            //me retorna el numero de la pregunta
            
        }
        return 0;
    }

    public int imprimiropcionpadre(int numCap, int idEncuesta){
        int numpregunta = imprimirpreguntas(numCap, idEncuesta);
        Optional<Integer> opciones = mostraridpadre.execute(numpregunta, numCap, idEncuesta);
        System.out.println(opciones);
        if (opciones.isPresent()) {
            int opcion = opciones.get();
            System.out.println(opcion);
            int numeroPreg = imprimirpreguntaid(opcion);
            if (numeroPreg == 0 ) {
                return 0; 
            } if (numeroPreg == -1) {
                Start();
            }
            int numeropc = imprimiropciones(numeroPreg, numCap, idEncuesta);
            return numeropc;             
        }else{
            int numeropc1 = imprimiropciones(numpregunta, numCap, idEncuesta);
            return numeropc1;
        }
    }


    public void Start(){
        int idencuesta = imprimircuestionarios();
        if (idencuesta == 0) {
            System.out.println("Saliendo del programa...");
            return; // Salida del método Start
        }else{
            int numerocap = imprimircapitulos(idencuesta);
            if (numerocap == 0 ) {
                return; 
            } if (numerocap == -1) {
                Start();
            } 
            int numopc = imprimiropcionpadre(numerocap, idencuesta);
            System.out.println(numopc
            
            );
            //numero pregunta = imprimir opcion padre
            // int numeroPreg = imprimirpreguntas(numerocap, idencuesta);
            // System.out.println(numeroPreg);
            // if (numeroPreg == 0 ) {
            //     return; 
            // } if (numeroPreg == -1) {
            //     Start();
            // } else {
            //     int numeroOpc = imprimiropcionpadre(numeroPreg, numerocap, idencuesta);

            // }
         }
    }
}

        
 
    

