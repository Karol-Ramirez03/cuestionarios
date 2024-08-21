package com.custionarios.subopcionRespuesta.infrastruture.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.funciones.Validaciones;
import com.custionarios.subopcionRespuesta.application.CreateSubOpcionesRespuestaUseCase;
import com.custionarios.subopcionRespuesta.application.DeleteSubOpcionesRespuestaUseCase;
import com.custionarios.subopcionRespuesta.application.FindAllSubOpcionesRespuestaUseCase;
import com.custionarios.subopcionRespuesta.application.FindByIdSubOpcionesRespuestaUseCase;
import com.custionarios.subopcionRespuesta.application.UpdateSubOpcionesRespuestaUseCase;
import com.custionarios.subopcionRespuesta.domain.entity.SubOpcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;
import com.custionarios.subopcionRespuesta.infrastruture.repository.SubOpcionesRespuestaRepository;


public class ConsoleAdapterSubOpcionesRespuesta {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;
    private CreateSubOpcionesRespuestaUseCase createSOR;
    private DeleteSubOpcionesRespuestaUseCase delSOR;
    private FindAllSubOpcionesRespuestaUseCase allSOR;
    private FindByIdSubOpcionesRespuestaUseCase idSOR;
    private UpdateSubOpcionesRespuestaUseCase updSOR;


    public ConsoleAdapterSubOpcionesRespuesta() {
        this.subOpcionesRespuestaService = new SubOpcionesRespuestaRepository();
        this.createSOR = new CreateSubOpcionesRespuestaUseCase(subOpcionesRespuestaService);
        this.delSOR = new DeleteSubOpcionesRespuestaUseCase(subOpcionesRespuestaService);
        this.allSOR = new FindAllSubOpcionesRespuestaUseCase(subOpcionesRespuestaService);
        this.idSOR = new FindByIdSubOpcionesRespuestaUseCase(subOpcionesRespuestaService);
        this.updSOR = new UpdateSubOpcionesRespuestaUseCase(subOpcionesRespuestaService);
    }

    public void Start(){
    String menu = """
                        1. agregar Sub Opciones
                        2. eliminar Sub Opciones
                        3. listar todos las Sub Opciones
                        4. buscar Sub Opciones por id
                        5. actualizar Sub Opciones
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
                    String numeroSubopcionstr = JOptionPane.showInputDialog(null, "Escriba el numero de Sub opcion: ");
                    int numeroSubopcion = Integer.parseInt(numeroSubopcionstr);
                    String idOpcionRespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la Opcion de Respuesta al que tiene relacion la sub opcion: ");
                    int idOpcionRespuesta = Integer.parseInt(idOpcionRespuestastr);
                    String componenteHtml = JOptionPane.showInputDialog(null, "Escriba el componente Html: ");
                    String textoSubopcion = JOptionPane.showInputDialog(null, "Escriba el texto de la Sub opcion: ");

                    SubOpcionesRespuesta sor = new SubOpcionesRespuesta(numeroSubopcion, idOpcionRespuesta, componenteHtml, textoSubopcion);
                    createSOR.execute(sor);
                    Start();
                        
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la Sub opcion para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delSOR.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder mensaje = new StringBuilder("Lista de sub opciones:\n");
                List<SubOpcionesRespuesta> sor = allSOR.execute();
                for (SubOpcionesRespuesta sortext : sor) {
                    int id = sortext.getId();
                    int numeroSubopcion = sortext.getNumeroSubopcion();
                    Timestamp creadoEn = sortext.getCreadoEn();
                    Timestamp actualizadoEn = sortext.getActualizadoEn();
                    int idOpcionRespuesta = sortext.getIdOpcionRespuesta();
                    String componenteHtml = sortext.getComponenteHtml();
                    String textoSubopcion = sortext.getTextoSubopcion();
                    

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("numero Sub opcion: ").append(numeroSubopcion).append(", ")
                    .append("creado En: ").append(creadoEn).append(", ")
                    .append("actualizado En: ").append(actualizadoEn).append(", ")
                    .append("id Opcion Respuesta: ").append(idOpcionRespuesta).append(", ")
                    .append("componente Html: ").append(componenteHtml).append(", ")
                    .append("texto Sub opcion: ").append(textoSubopcion).append("\n\n");
     
                }

                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 

        
                JOptionPane.showMessageDialog(null, scrollPane, "Sub opciones", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id de la Sub opcion para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<SubOpcionesRespuesta> dato = idSOR.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("usuarios:\n");

                    if (dato.isPresent()) {
                        SubOpcionesRespuesta sub = dato.get();
                        int id = sub.getId();
                        int numeroSubopcion = sub.getNumeroSubopcion();
                        Timestamp creadoEn = sub.getCreadoEn();
                        Timestamp actualizadoEn = sub.getActualizadoEn();
                        int idOpcionRespuesta = sub.getIdOpcionRespuesta();
                        String componenteHtml = sub.getComponenteHtml();
                        String textoSubopcion = sub.getTextoSubopcion();
                        

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("numero Sub opcion: ").append(numeroSubopcion).append("\n")
                        .append("creado En: ").append(creadoEn).append("\n")
                        .append("actualizado En: ").append(actualizadoEn).append("\n")
                        .append("id Opcion Respuesta: ").append(idOpcionRespuesta).append("\n")
                        .append("componente Html: ").append(componenteHtml).append("\n")
                        .append("texto Sub opcion: ").append(textoSubopcion).append("\n\n");
        
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
                String idsub = JOptionPane.showInputDialog(null, "Escriba el id de la SubOpcion para buscar: ");
                int idByupd = Integer.parseInt(idsub);
                Optional<SubOpcionesRespuesta> dato = idSOR.execute(idByupd);
                SubOpcionesRespuesta datoupd = dato.get();
                while (bandera) {
                    String opcionesUpd = """
                        1. numero Sub opcion
                        2. id Opcion de Respuesta
                        3. componenteHtml
                        4. texto Sub opcion
                        5. salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,5);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo numero de Sub opcion"));
                                    datoupd.setNumeroSubopcion(num);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                               
                                break;
                            case 2:
                                try {
                                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));
                                    datoupd.setIdOpcionRespuesta(num);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 3:
                                datoupd.setComponenteHtml(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));
                                
                                break;
                            case 4:
                                datoupd.setTextoSubopcion(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));    
                                break;
                            case 5:
                                bandera = false;
                                break;
                            }
                        }else {
                            bandera = false;
                        }
                } 
                updSOR.execute(datoupd);
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
