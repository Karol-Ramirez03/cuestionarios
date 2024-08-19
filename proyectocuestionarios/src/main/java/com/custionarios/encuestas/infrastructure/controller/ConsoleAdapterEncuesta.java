package com.custionarios.encuestas.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.encuestas.application.CreateEncuestaUseCase;
import com.custionarios.encuestas.application.DeleteEncuestaUseCase;
import com.custionarios.encuestas.application.FindAllEncuestaUseCase;
import com.custionarios.encuestas.application.FindByIdEncuestaUseCase;
import com.custionarios.encuestas.application.UpdateEncuestaUseCase;
import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;
import com.custionarios.encuestas.infrastructure.repository.EncuestaRepository;
import com.custionarios.funciones.Validaciones;

public class ConsoleAdapterEncuesta {
    private EncuestaService encuestaService;
    private CreateEncuestaUseCase createencuesta;
    private DeleteEncuestaUseCase delencuesta;
    private FindByIdEncuestaUseCase idencuesta;
    private FindAllEncuestaUseCase allencuesta;
    private UpdateEncuestaUseCase updencuesta;

    public ConsoleAdapterEncuesta() {
        this.encuestaService = new EncuestaRepository();
        this.createencuesta = new CreateEncuestaUseCase(encuestaService);
        this.delencuesta = new DeleteEncuestaUseCase(encuestaService);
        this.idencuesta = new FindByIdEncuestaUseCase(encuestaService);
        this.allencuesta = new FindAllEncuestaUseCase(encuestaService);
        this.updencuesta = new UpdateEncuestaUseCase(encuestaService);
    }

    public void Start(){
    String menu = """
                        1. agregar Encuesta
                        2. eliminar Encuesta
                        3. listar todos las Encuestas
                        4. buscar Encuesta por id
                        5. actualizar Encuesta
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
                String descripcion = JOptionPane.showInputDialog(null, "Escriba la descripcion de la encuesta : ");
                String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la encuesta: ");

                Encuesta Encuesta = new Encuesta(descripcion, nombre);
                createencuesta.execute(Encuesta);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del Encuesta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delencuesta.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Encuestas:\n");
                List<Encuesta> Encuestas = allencuesta.execute();
                for (Encuesta encuesta : Encuestas) {

                    int id = encuesta.getId();
                    Timestamp creadoEn = encuesta.getCreadoEn();
                    Timestamp actualizadoEn = encuesta.getActualizadoEn();
                    String descripcion =  encuesta.getDescripcion();
                    String nombre =  encuesta.getNombre();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("creado en: ").append(creadoEn).append("\n")
                    .append("actualizado en: ").append(actualizadoEn).append("\n")
                    .append("descripcion: ").append(descripcion).append("\n")
                    .append("nombre: ").append(nombre).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Encuestas", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Encuesta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Encuesta> dato = idencuesta.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Encuestas:\n");
                    if (dato.isPresent()) {
                        Encuesta datopre = dato.get();
                        int id = datopre.getId();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String descripcion =  datopre.getDescripcion();
                        String nombre =  datopre.getNombre();
    
                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("creado en: ").append(creadoEn).append("\n")
                        .append("actualizado en: ").append(actualizadoEn).append("\n")
                        .append("descripcion: ").append(descripcion).append("\n")
                        .append("nombre: ").append(nombre).append("\n\n");
         
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Encuesta para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Encuesta> dato = idencuesta.execute(iduserupd);
                Encuesta EncuestaUpd = dato.get();
                while (bandera) {
                    
                    String opcionesUpd = """
                        1. descripcion
                        2. nombre
                        3. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,3);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                EncuestaUpd.setDescripcion(JOptionPane.showInputDialog(null, "ingresa la nueva descripcion"));
                                break;
                            case 2:
                                EncuestaUpd.setNombre(JOptionPane.showInputDialog(null," ingrese el nuevo nombre: "));
                                break;
                            case 3:
                                bandera = false;
                                break;
                            }
                        }
                } 
                updencuesta.execute(EncuestaUpd);
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
