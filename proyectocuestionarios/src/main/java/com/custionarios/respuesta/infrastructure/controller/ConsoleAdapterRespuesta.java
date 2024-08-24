package com.custionarios.respuesta.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.funciones.Validaciones;
import com.custionarios.respuesta.application.CreateRespuestaUseCase;
import com.custionarios.respuesta.application.DeleteRespuestaUseCase;
import com.custionarios.respuesta.application.FindAllRespuestaUseCase;
import com.custionarios.respuesta.application.FindByIdRespuestaUseCase;
import com.custionarios.respuesta.application.UpdateRespuestaUseCase;
import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;
import com.custionarios.respuesta.infrastructure.repository.RespuestaRepository;

public class ConsoleAdapterRespuesta {

    private RespuestaService respuestaService;
    private CreateRespuestaUseCase createresp;
    private DeleteRespuestaUseCase delresp;
    private FindAllRespuestaUseCase allresp;
    private FindByIdRespuestaUseCase idresp;
    private UpdateRespuestaUseCase updresp;

    

    public ConsoleAdapterRespuesta() {
            this.respuestaService = new RespuestaRepository();
            this.createresp = new CreateRespuestaUseCase(respuestaService);
            this.delresp = new DeleteRespuestaUseCase(respuestaService);
            this.allresp = new FindAllRespuestaUseCase(respuestaService);
            this.idresp = new FindByIdRespuestaUseCase(respuestaService);
            this.updresp = new UpdateRespuestaUseCase(respuestaService);
        }
            
    public void Start(){
    String menu = """
                        1. agregar Respuesta
                        2. eliminar Respuesta
                        3. listar todos las Respuestas
                        4. buscar Respuesta por id
                        5. actualizar Respuesta
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
                Integer idRespuesta = null;
                Integer idSubrespuesta = null;
            
                String idRespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la opcion escogida: ");
                if (idRespuestastr != null && !idRespuestastr.trim().isEmpty()) {
                    idRespuesta = Integer.parseInt(idRespuestastr);
                }
            
                String idSubrespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la sub opcion escogida: ");
                if (idSubrespuestastr != null && !idSubrespuestastr.trim().isEmpty()) {
                    idSubrespuesta = Integer.parseInt(idSubrespuestastr);
                }
            
                String textoRespuesta = JOptionPane.showInputDialog(null, "Escriba tu respuesta: ");
                Respuesta respuesta = new Respuesta(idRespuesta, idSubrespuesta, textoRespuesta);
                createresp.execute(respuesta);
                
                Start();
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Problemas en el ingreso de datos, vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delresp.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Respuestas:\n");
                List<Respuesta> Respuestas = allresp.execute();
                for (Respuesta Respuesta : Respuestas) {
                    int id = Respuesta.getId();
                    int idRespuesta = Respuesta.getIdRespuesta();
                    int idSubrespuesta = Respuesta.getIdSubrespuesta();
                    String textoRespuesta =  Respuesta.getTextoRespuesta();

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("idRespuesta: ").append(idRespuesta).append("\n")
                    .append("idSubrespuesta: ").append(idSubrespuesta).append("\n")
                    .append("textoRespuesta: ").append(textoRespuesta).append("\n\n");
     
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
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Respuesta> dato = idresp.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Respuestas:\n");
                    if (dato.isPresent()) {
                        Respuesta datopre = dato.get();
                        int id = datopre.getId();
                        int idRespuesta = datopre.getIdRespuesta();
                        int idSubrespuesta = datopre.getIdSubrespuesta();
                        String textoRespuesta =  datopre.getTextoRespuesta();

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("idRespuesta: ").append(idRespuesta).append("\n")
                        .append("idSubrespuesta: ").append(idSubrespuesta).append("\n")
                        .append("textoRespuesta: ").append(textoRespuesta).append("\n\n");
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
                Optional<Respuesta> dato = idresp.execute(iduserupd);
                Respuesta RespuestaUpd = dato.get();
                while (bandera) {
                    
                    String opcionesUpd = """
                        1. idRespuesta
                        2. idSubrespuesta
                        3. textoRespuesta
                        4. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,4);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    String respuestaStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo id Respuesta: ");
                                    Integer respuesta = null;
                                
                                    if (respuestaStr != null && !respuestaStr.trim().isEmpty()) {
                                        respuesta = Integer.parseInt(respuestaStr);
                                    }
                                    RespuestaUpd.setIdRespuesta(respuesta);
                                
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Problemas en el ingreso de datos. Vuelve a intentarlo.");
                                    Start();
                                }
                                break;
                            case 2:
                                try {
                                    String respuestaStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo id Sub respuesta: ");
                                    Integer idSubrespuesta = null;
                                
                                    if (respuestaStr != null && !respuestaStr.trim().isEmpty()) {
                                        idSubrespuesta = Integer.parseInt(respuestaStr);
                                    }
                                
                                    RespuestaUpd.setIdSubrespuesta(idSubrespuesta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Problemas en el ingreso de datos. Vuelve a intentarlo.");
                                    Start();
                                }
                            
                                break;
                            case 3:
                                RespuestaUpd.setTextoRespuesta(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto"));
                                break;
                            case 4:
                                bandera = false;
                                break;
                            }
                        } else {
                            bandera = false;
                        }
                } 
                updresp.execute(RespuestaUpd);
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
