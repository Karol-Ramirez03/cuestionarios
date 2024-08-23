package com.custionarios.preguntas.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.funciones.Validaciones;
import com.custionarios.preguntas.application.CreatePreguntaUseCase;
import com.custionarios.preguntas.application.DeletePreguntaUseCase;
import com.custionarios.preguntas.application.FindAllPreguntaUseCase;
import com.custionarios.preguntas.application.FindByIdPreguntaUseCase;
import com.custionarios.preguntas.application.UpdatePreguntaUseCase;
import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;
import com.custionarios.preguntas.infrastructure.repository.PreguntaRepository;


public class ConsoleAdapterPregunta {
    private PreguntaService preguntaService;
    private CreatePreguntaUseCase createPregunta;
    private DeletePreguntaUseCase delpregunta;
    private FindAllPreguntaUseCase allPregunta;
    private FindByIdPreguntaUseCase idpregunta;
    private UpdatePreguntaUseCase updPregunta;

    public ConsoleAdapterPregunta() {
        this.preguntaService = new PreguntaRepository();
        this.createPregunta = new CreatePreguntaUseCase(preguntaService);
        this.delpregunta = new DeletePreguntaUseCase(preguntaService);
        this.allPregunta = new FindAllPreguntaUseCase(preguntaService);
        this.idpregunta = new FindByIdPreguntaUseCase(preguntaService);
        this.updPregunta = new UpdatePreguntaUseCase(preguntaService);
    }






    public void Start(){
    String menu = """
                        1. agregar Pregunta
                        2. eliminar Pregunta
                        3. listar todos las Preguntas
                        4. buscar Pregunta por id
                        5. actualizar Pregunta
                        6. salir
                        """;
    Optional<Integer> opcion = Validaciones.mostrarOpciones(menu,1,6);

    if (opcion.isPresent()) {
        int numero = opcion.get();
        ejecutarOpcion(numero);
    } 

  
    }
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
            try {
                String idCapitulostr = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo escogido: ");
                int idCapitulo = Integer.parseInt(idCapitulostr);
                String tipoPregunta = JOptionPane.showInputDialog(null, "Escriba tipo de Pregunta que se espera recibir: ");
                String comentarioPregunta = JOptionPane.showInputDialog(null, "Escriba el comentario a la Pregunta : ");
                String textoPregunta = JOptionPane.showInputDialog(null, "Escriba el texto de la Pregunta: ");

                
                Pregunta Pregunta = new Pregunta(idCapitulo, tipoPregunta, comentarioPregunta, textoPregunta);
                createPregunta.execute(Pregunta);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la pregunta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delpregunta.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Preguntas:\n");
                List<Pregunta> Preguntas = allPregunta.execute();
                for (Pregunta Pregunta : Preguntas) {
                    int id = Pregunta.getId();
                    int idCapitulo = Pregunta.getIdCapitulo();
                    Timestamp creadoEn = Pregunta.getCreadoEn();
                    Timestamp actualizadoEn = Pregunta.getActualizadoEn();
                    String numeroPregunta = Pregunta.getNumeroPregunta();
                    String tipoRespuesta = Pregunta.getTipoRespuesta();
                    String comentarioPregunta = Pregunta.getComentarioPregunta();
                    String textoPregunta = Pregunta.getTextoPregunta();

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("id Capitulo: ").append(idCapitulo).append(", ")
                    .append("creado En: ").append(creadoEn).append("\n")
                    .append("actualizado En: ").append(actualizadoEn).append("\n")
                    .append("numero de Pregunta: ").append(numeroPregunta).append(", ")
                    .append("tipo de Respuesta: ").append(tipoRespuesta).append("\n")
                    .append("comentario Pregunta: ").append(comentarioPregunta).append("\n")
                    .append("texto Pregunta: ").append(textoPregunta).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Preguntas", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Pregunta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Pregunta> dato = idpregunta.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Preguntas:\n");
                    if (dato.isPresent()) {
                        Pregunta datopre = dato.get();
                        int id = datopre.getId();
                        int idCapitulo = datopre.getIdCapitulo();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String numeroPregunta = datopre.getNumeroPregunta();
                        String tipoRespuesta = datopre.getTipoRespuesta();
                        String comentarioPregunta = datopre.getComentarioPregunta();
                        String textoPregunta = datopre.getComentarioPregunta();

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("id Capitulo: ").append(idCapitulo).append("\n")
                        .append("creado En: ").append(creadoEn).append("\n")
                        .append("actualizado En: ").append(actualizadoEn).append("\n")
                        .append("numero de Pregunta: ").append(numeroPregunta).append("\n")
                        .append("tipo de Respuesta: ").append(tipoRespuesta).append("\n")
                        .append("comentario Pregunta: ").append(comentarioPregunta).append("\n")
                        .append("texto Pregunta: ").append(textoPregunta).append("\n\n");
        
                    } 
                    JOptionPane.showMessageDialog(null, mensajeid);
                    Start();
    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
               
                break;
            case 5:
            try {
                boolean bandera = true;
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Pregunta para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Pregunta> dato = idpregunta.execute(iduserupd);
                Pregunta PreguntaUpd = dato.get();
                while (bandera) {

                    String opcionesUpd = """
                        1. id Capitulo
                        2. tipo Respuesta
                        3. comentario Pregunta
                        4. textoPregunta
                        5. salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,6);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int Pregunta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id del capitulo"));
                                    PreguntaUpd.setIdCapitulo(Pregunta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            
                            case 2:
                                PreguntaUpd.setTipoRespuesta(JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo Respuesta"));
                                break;
                            case 3:
                                PreguntaUpd.setComentarioPregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo comentario Pregunta"));
                                break;
                            case 4:
                                PreguntaUpd.setTextoPregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto"));
                                break;
                            case 5:
                                bandera = false;
                                break;
                            }
                        } else {
                            bandera = false;
                        }
                } 
                updPregunta.execute(PreguntaUpd);
                Start();
                
            } catch (Exception e) {
                e.printStackTrace();
                Start();
            }
                break;
            case 6:
                break;
            default:
                break;
        }
    }
}
