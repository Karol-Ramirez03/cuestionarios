package com.custionarios.GenerarCuestionarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.application.MostrarCapitulosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarCuestionariosUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarOpcionesUseCase;
import com.custionarios.GenerarCuestionarios.application.MostrarPreguntasUseCase;
import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;
import com.custionarios.GenerarCuestionarios.infrastructure.repository.GenerarCuestionariosRepository;
import com.custionarios.funciones.Validaciones;


public class ConsoleAdapterGenerarCuestionarios {
    private GenerarCuestionariosService generarCuestionariosService;
    private MostrarCuestionariosUseCase mostrar;
    private MostrarCapitulosUseCase mostrarCap;
    private MostrarPreguntasUseCase mostrarPreg;
    private MostrarOpcionesUseCase mostrarOpc;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUseCase(generarCuestionariosService);
        this.mostrarCap = new MostrarCapitulosUseCase(generarCuestionariosService);
        this.mostrarPreg = new MostrarPreguntasUseCase(generarCuestionariosService);
        this.mostrarOpc = new MostrarOpcionesUseCase(generarCuestionariosService);
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
            int num = Validaciones.elegiropcion(JOptionPane.showInputDialog(null,sb));
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
                    StringBuilder opc = new StringBuilder();
                    Optional<List<GenerarCuestionarios>> opciones = mostrarOpc.execute(numPreg);
                    
                    if (opciones.isPresent()) {
                        List<GenerarCuestionarios> listOpciones = opciones.get();
                        System.out.println("hola");
                        for (GenerarCuestionarios opcion : listOpciones) {
                            int idopc = opcion.getIndice();
                            String nombreopc = opcion.getNombre();
                            System.out.println(idopc);
                            System.out.println(nombreopc);

                            opc.append(idopc).append(" - ").append(nombreopc.toString()).append("\n"); 
                        }
                    int numOpc = Integer.parseInt(JOptionPane.showInputDialog(null,opc));
                    } else {
                        System.out.println("chao");
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
                Start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error!, Vuelve a intentarlo");
            Start();
        }

//         CREATE TABLE subopciones_respuesta (
//     id INT AUTO_INCREMENT,
//     numero_subopcion INT NOT NULL,
//     creado_en TIMESTAMP,
//     actualizado_en TIMESTAMP,
//     id_opcion_respuesta INT,
//     componente_html VARCHAR(255),
//     texto_subopcion VARCHAR(255),
//     CONSTRAINT pk_subopciones_respuesta PRIMARY KEY (id),
//     CONSTRAINT fk_subopciones_opcion FOREIGN KEY (id_opcion_respuesta) REFERENCES opciones_respuesta(id)
// );
        
        


    }

    
    
}
