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
import com.custionarios.GenerarCuestionarios.application.ObtenerIdOpcionByValorUseCase;
import com.custionarios.GenerarCuestionarios.application.ObtenerIdOpcionUseCase;
import com.custionarios.GenerarCuestionarios.application.ObtenerOpcionesByIdUsecase;
import com.custionarios.GenerarCuestionarios.application.ObtenerPreguntaHijaUseCase;
import com.custionarios.GenerarCuestionarios.application.ObtenerSubOpcionesByIdUseCase;
import com.custionarios.GenerarCuestionarios.application.RetornaIdSubOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.RetornarIdSubOpcionPorValorUseCase;
import com.custionarios.GenerarCuestionarios.application.preguntaAbiertaUseCase;
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
    private ObtenerIdOpcionUseCase GetIdOpcion;
    private ObtenerPreguntaHijaUseCase GetPreguntaHija;
    private ObtenerOpcionesByIdUsecase idcase;
    private ObtenerIdOpcionUseCase opcionIdCase;
    private ObtenerSubOpcionesByIdUseCase subopcionByid;
    private ObtenerIdOpcionByValorUseCase idOpcionValor;
    private RetornaIdSubOpcionesUseCase retornarSubOpcion;
    private RetornarIdSubOpcionPorValorUseCase retornarSubValor;
    private preguntaAbiertaUseCase preguntaAbierta;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
        this.mostrarPreg = new MostrarPreguntasUseCase(generarCuestionariosService);
        this.mostrarOpc = new MostrarOpcionesUseCase(generarCuestionariosService);
        
        this.mostrarSub = new MostrarSubOpcionesUseCase(generarCuestionariosService);
        this.mostraridpadre = new MostraropcionidpadreUseCase(generarCuestionariosService);
        this.mostrarPregID = new MostrarPreguntaByIdUseCase(generarCuestionariosService);
        this.GetIdOpcion = new ObtenerIdOpcionUseCase(generarCuestionariosService);
        this.GetPreguntaHija = new ObtenerPreguntaHijaUseCase(generarCuestionariosService);
        this.idcase = new ObtenerOpcionesByIdUsecase(generarCuestionariosService);
        this.opcionIdCase = new ObtenerIdOpcionUseCase(generarCuestionariosService);
        this.subopcionByid = new ObtenerSubOpcionesByIdUseCase(generarCuestionariosService);
        this.idOpcionValor = new ObtenerIdOpcionByValorUseCase(generarCuestionariosService);
        this.retornarSubOpcion = new RetornaIdSubOpcionesUseCase(generarCuestionariosService);
        this.retornarSubValor = new RetornarIdSubOpcionPorValorUseCase(generarCuestionariosService);
        this.preguntaAbierta = new preguntaAbiertaUseCase(generarCuestionariosService);
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
    public Optional<Integer>  imprimiropciones(int numpregunta,int numCap, int idEncuesta){
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
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    //me retorna el valor de la opcion

    public void imprimirpreguntaid(int id){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> capitulos = mostrarPregID.execute(id);
        if (capitulos.isPresent()) {
            List<GenerarCuestionarios> capit = capitulos.get();
            for (GenerarCuestionarios cap : capit) {
                st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
            }
            JOptionPane.showMessageDialog(null,st);
            
        }
    }
    public Optional<Integer> mostraropcionesbyid(int idpregunta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> opciones = idcase.execute(idpregunta);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    //valor opcion

    public Optional<Integer> mostrasubopcionesByid(int idopcion){
        StringBuilder st = new StringBuilder();
         Optional<List<GenerarCuestionarios>> opciones = subopcionByid.execute(idopcion);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    public Optional<Integer> mostrarSubOpciones(int idEncuesta,int numCapitulo, int numPreg, int valorOpc){
        StringBuilder st = new StringBuilder();
         Optional<List<GenerarCuestionarios>> opciones = mostrarSub.execute(idEncuesta, numCapitulo, numPreg, valorOpc);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }

    public void ImprimirPreguntasHijas(int id_encuesta,int numero_capitulo, int numero_pregunta, int valor_opcion){
        Optional<List<GenerarCuestionarios>> idopciones = GetIdOpcion.execute(id_encuesta, numero_capitulo, numero_pregunta, valor_opcion);
        if (idopciones.isPresent()) {//obtener el id de la opcion
            List<GenerarCuestionarios> findOpciones = idopciones.get();
            for (GenerarCuestionarios idopc : findOpciones) {
                int ids = idopc.getId(); 
             //error aqui
                Optional<List<GenerarCuestionarios>> preguntas = GetPreguntaHija.execute(ids);
                if (preguntas.isPresent()) { //me deberia retornar las preguntas
                    List<GenerarCuestionarios>  hacerPreguntas = preguntas.get();
                    for (GenerarCuestionarios preg : hacerPreguntas) {
                        int idpregunta = preg.getId();
                        imprimirpreguntaid(idpregunta);
                        //numero pregunta 
                        Optional<Integer> opcionNum = mostraropcionesbyid(idpregunta);
                        // numero de opcion elegida
                        if (opcionNum.isPresent()) {
                            int valor = opcionNum.get();
                            Optional<Integer>  opcion = idOpcionValor.execute(idpregunta, valor);
                            if (opcion.isPresent()) {
                                int idopcion = opcion.get(); // ME DA EL ID DE LA OPCION
                                Optional<Integer> subopcion = mostrasubopcionesByid(idopcion);
                                if (subopcion.isPresent()) {
                                    int idSub = subopcion.get();
                                    int idSubopcion = retornarSubValor.execute(idopcion, idSub);
                                    //logica para guardar subopcion "esto retorna el numero"
                                    /*
                                     * 
                                     *
                                     * */

                                    
                                } else {
                                    //idopcion logica guardar
                                    
                                    //LE PASO ID "OPCION " SI OPCION ES NULL O VACIA RETORNA TRUE Y HABRE UN INPUT

                                }
                            
                            }
                            
                        }
                        // int idopcion = opcionIdCase.
                        
                    }
                    
                }
            }
            
        } else{
            // logicaa de buscar subopciones 
            // logica de guardar opcion 
            //creo que no nesecita logica
            return;
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
            int numeroPreg = imprimirpreguntas(numerocap, idencuesta);
            System.out.println(numeroPreg);
            if (numeroPreg == 0 ) {
                return; 
            } if (numeroPreg == -1) {
                Start();
            } else {

            }
            Optional<Integer> numeroopc = imprimiropciones(numerocap, numeroPreg, idencuesta);
            if (numeroopc.isPresent()) {
                int valoropcion = numeroopc.get();
                //si valor opcion es 
                ImprimirPreguntasHijas(idencuesta, numerocap, numeroPreg,valoropcion);
                Optional<Integer> valorOpcion = mostrarSubOpciones(idencuesta, numerocap, numeroPreg, valoropcion);//CREO QUE RETORNA EL VALOR DE LA OPCION
                if (valorOpcion.isPresent()) {
                    int Opcion = valorOpcion.get();
                    int idSub = retornarSubOpcion.execute(idencuesta, numerocap, numeroPreg, valoropcion, Opcion);//EL ID DE LA SUBOPCION

                    //guardar subopcion
                } else {
                    Optional<List<GenerarCuestionarios>> idOpc = GetIdOpcion.execute(idencuesta, numerocap, numeroPreg, valoropcion); //retorna el id de la opcion
                    if (idOpc.isPresent()) {
                        List<GenerarCuestionarios> listaids = idOpc.get();
                        for (GenerarCuestionarios opc : listaids) {
                            int opcion = opc.getId();

                            Optional<String> Stringvalidar = preguntaAbierta.execute(opcion);
                            if (Stringvalidar.isPresent()) {
                                String validar = Stringvalidar.get();
                                if (validar == null ) {
                                    String respuestaABIERTA = JOptionPane.showInputDialog(null,"escriba su respuesta");
                                }
                                
                            } else {
                                // guardar opcion de tipo id 

                            }

                            //logicca de guardar 
                            //LE PASO ID "OPCION " SI OPCION ES NULL O VACIA RETORNA TRUE Y HABRE UN INPUT
                        }
                        
                    }
                    //guardar opcion
                    
                }
                
            }
         }
    }
}

        
 
    

