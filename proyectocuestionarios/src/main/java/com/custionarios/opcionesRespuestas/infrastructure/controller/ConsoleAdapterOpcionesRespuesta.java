package com.custionarios.opcionesRespuestas.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.funciones.Validaciones;
import com.custionarios.opcionesRespuestas.application.CreateOpcionesRespuestaUseCase;
import com.custionarios.opcionesRespuestas.application.DeleteOpcionesRespuestaUseCase;
import com.custionarios.opcionesRespuestas.application.FindAllOpcionesRespuestaUseCase;
import com.custionarios.opcionesRespuestas.application.FindByIdOpcionesRespuestaUseCase;
import com.custionarios.opcionesRespuestas.application.UpdateOpcionesRespuestaUseCase;
import com.custionarios.opcionesRespuestas.domain.entity.OpcionesRespuesta;
import com.custionarios.opcionesRespuestas.domain.service.OpcionesRespuestaService;
import com.custionarios.opcionesRespuestas.infrastructure.repository.OpcionesRespuestaRepository;


public class ConsoleAdapterOpcionesRespuesta {

    private OpcionesRespuestaService opcionesRespuestaService;
    private CreateOpcionesRespuestaUseCase creatOR;
    private DeleteOpcionesRespuestaUseCase delOR;
    private FindByIdOpcionesRespuestaUseCase idOR;
    private FindAllOpcionesRespuestaUseCase allOR;
    private UpdateOpcionesRespuestaUseCase updOR;


    public ConsoleAdapterOpcionesRespuesta() {
        this.opcionesRespuestaService = new OpcionesRespuestaRepository();
        this.creatOR = new CreateOpcionesRespuestaUseCase(opcionesRespuestaService);
        this.delOR = new DeleteOpcionesRespuestaUseCase(opcionesRespuestaService);
        this.idOR = new FindByIdOpcionesRespuestaUseCase(opcionesRespuestaService);
        this.allOR = new FindAllOpcionesRespuestaUseCase(opcionesRespuestaService);
        this.updOR = new UpdateOpcionesRespuestaUseCase(opcionesRespuestaService);
    } 

    public void Start(){
    String menu = """
                        1. agregar OpcionesRespuesta
                        2. eliminar OpcionesRespuesta
                        3. listar todos las OpcionesRespuestas
                        4. buscar OpcionesRespuesta por id
                        5. actualizar OpcionesRespuesta
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
                int idCategoriaCatalogo = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el id de Categoria Catalogo: "));
                int idPregunta = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el id de la Pregunta relacionada: "));
                
                Integer idOpcionPadre = null;
                String idOpcionPadreStr = JOptionPane.showInputDialog(null, "Escriba el id Opcion Padre (opcional /enter para continuar): ");
                if (idOpcionPadreStr != null && !idOpcionPadreStr.trim().isEmpty()) {
                    try {
                        idOpcionPadre = Integer.parseInt(idOpcionPadreStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error al ingresar id Opcion Padre. Debe ser un número entero.");
                        e.printStackTrace();
                        Start();
                        return;
                    }
                }
                
                String tipoComponenteHtml = JOptionPane.showInputDialog(null, "Escriba el tipo de Componente Html: ");
                String comentarioRespuesta = JOptionPane.showInputDialog(null, "Escriba el comentario de la Opcion: ");
                String textoOpcion = JOptionPane.showInputDialog(null, "Escriba el texto de la opcion: ");
                
                OpcionesRespuesta respuesta = new OpcionesRespuesta(idCategoriaCatalogo, idPregunta, idOpcionPadre, tipoComponenteHtml, comentarioRespuesta, textoOpcion);
                creatOR.execute(respuesta);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Problemas en el ingreso de datos. Vuelve a intentarlo.");
                e.printStackTrace();
                Start();
            }
            break;
    
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la Opcion de Respuesta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delOR.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de OpcionesRespuestas:\n");
                List<OpcionesRespuesta> OpcionesRespuestas = allOR.execute();
                for (OpcionesRespuesta opcionesRespuesta : OpcionesRespuestas) {
                    int id = opcionesRespuesta.getId();
                    int valor_opcion = opcionesRespuesta.getValorOpcion();
                    int id_categoria_catalogo = opcionesRespuesta.getIdCategoriaCatalogo();
                    int id_pregunta = opcionesRespuesta.getIdPregunta();
                    Timestamp creado_en = opcionesRespuesta.getCreadoEn();
                    Timestamp actualizado_en = opcionesRespuesta.getActualizadoEn();
                    int id_opcion_padre = opcionesRespuesta.getIdOpcionPadre();
                    String tipo_componente_html =  opcionesRespuesta.getTipoComponenteHtml();
                    String comentario_respuesta =  opcionesRespuesta.getComentarioRespuesta();
                    String texto_opcion =  opcionesRespuesta.getTextoOpcion();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("valor opcion: ").append(valor_opcion).append("\n")
                    .append("id categoria catalogo: ").append(id_categoria_catalogo).append("\n")
                    .append("id pregunta : ").append(id_pregunta).append("\n")
                    .append("creado en: ").append(creado_en).append("\n")
                    .append("actualizado en: ").append(actualizado_en).append("\n")
                    .append("id opcion padre: ").append(id_opcion_padre).append("\n")
                    .append("tipo componente html: ").append(tipo_componente_html).append("\n")
                    .append("comentario respuesta: ").append(comentario_respuesta).append("\n")
                    .append("texto opcion: ").append(texto_opcion).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Respuestas", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id de la Opcion de Respuesta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<OpcionesRespuesta> dato = idOR.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("OpcionesRespuestas:\n");
                    if (dato.isPresent()) {
                        OpcionesRespuesta datopre = dato.get();
                        int id = datopre.getId();
                        int valor_opcion = datopre.getValorOpcion();
                        int id_categoria_catalogo = datopre.getIdCategoriaCatalogo();
                        int id_pregunta = datopre.getIdPregunta();
                        Timestamp creado_en = datopre.getCreadoEn();
                        Timestamp actualizado_en = datopre.getActualizadoEn();
                        int id_opcion_padre = datopre.getIdOpcionPadre();
                        String tipo_componente_html =  datopre.getTipoComponenteHtml();
                        String comentario_respuesta =  datopre.getComentarioRespuesta();
                        String texto_opcion =  datopre.getTextoOpcion();

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("valor opcion: ").append(valor_opcion).append("\n")
                        .append("id categoria catalogo: ").append(id_categoria_catalogo).append("\n")
                        .append("id pregunta : ").append(id_pregunta).append("\n")
                        .append("creado en: ").append(creado_en).append("\n")
                        .append("actualizado en: ").append(actualizado_en).append("\n")
                        .append("id opcion padre: ").append(id_opcion_padre).append("\n")
                        .append("tipo componente html: ").append(tipo_componente_html).append("\n")
                        .append("comentario respuesta: ").append(comentario_respuesta).append("\n")
                        .append("texto opcion: ").append(texto_opcion).append("\n\n");
        
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<OpcionesRespuesta> dato = idOR.execute(iduserupd);
                OpcionesRespuesta RespuestaUpd = dato.get();
                while (bandera) {
                    String opcionesUpd = """
                        1. id Categoria Catalogo
                        2. id Pregunta
                        3. id Opcion Padre
                        4. tipo de Componente Html
                        5. comentario Respuesta
                        6. texto 
                        7. salir 
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,8);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id Categoria Catalogo"));
                                    RespuestaUpd.setIdCategoriaCatalogo(respuesta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 2:
                                try {
                                    int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id Pregunta"));
                                    RespuestaUpd.setIdPregunta(respuesta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 3:
                            try {
                                Integer idOpcionPadre = null;
                                String idOpcionPadreStr = JOptionPane.showInputDialog(null, "Escriba el id Opcion Padre (opcional /enter para continuar): ");
                                
                                if (idOpcionPadreStr != null && !idOpcionPadreStr.trim().isEmpty()) {
                                    try {
                                        idOpcionPadre = Integer.parseInt(idOpcionPadreStr);
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "El ID Opción Padre debe ser un número válido.");
                                        Start();
                                        return; 
                                    }
                                }
                                
                                RespuestaUpd.setIdOpcionPadre(idOpcionPadre);
                                
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Problemas en el ingreso de datos, vuelve a intentarlo.");
                                Start();
                            }
                                break;
                            case 4:
                                RespuestaUpd.setTipoComponenteHtml(JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de Componente Html"));
                                break;
                            case 5:
                                RespuestaUpd.setComentarioRespuesta(JOptionPane.showInputDialog(null, "Ingrese el nuevo comentario Respuesta"));
                                break;
                            case 6:
                                RespuestaUpd.setTextoOpcion(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto"));
                                break;
                            case 7:
                                bandera = false;
                                break;
                            }
                        } else {
                            bandera = false;
                        }
                } 
                
                updOR.execute(RespuestaUpd);
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
