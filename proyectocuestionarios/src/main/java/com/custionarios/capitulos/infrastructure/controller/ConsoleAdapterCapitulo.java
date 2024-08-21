package com.custionarios.capitulos.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.capitulos.application.CreateCapituloUseCase;
import com.custionarios.capitulos.application.DeleteCapituloUseCase;
import com.custionarios.capitulos.application.FindAllCapituloUseCase;
import com.custionarios.capitulos.application.FindByIdCapituloUseCase;
import com.custionarios.capitulos.application.UpdateCapituloUseCase;
import com.custionarios.capitulos.domain.entity.Capitulo;
import com.custionarios.capitulos.domain.service.CapituloService;
import com.custionarios.capitulos.infrastructure.repository.CapituloRepository;
import com.custionarios.funciones.Validaciones;

public class ConsoleAdapterCapitulo {
    private CapituloService capituloService;
    private CreateCapituloUseCase createCap;
    private DeleteCapituloUseCase delCap;
    private FindAllCapituloUseCase allCap;
    private FindByIdCapituloUseCase idCap;
    private UpdateCapituloUseCase updCap;
    
    public ConsoleAdapterCapitulo() {
        this.capituloService = new CapituloRepository();
        this.createCap = new CreateCapituloUseCase(capituloService);
        this.delCap = new DeleteCapituloUseCase(capituloService);
        this.allCap = new FindAllCapituloUseCase(capituloService);
        this.idCap = new FindByIdCapituloUseCase(capituloService);
        this.updCap = new UpdateCapituloUseCase(capituloService);
    }

    public void Start(){
    String menu = """
                        1. agregar Capitulo
                        2. eliminar Capitulo
                        3. listar todos las Capitulos
                        4. buscar Capitulo por id
                        5. actualizar Capitulo
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
                int idEncuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el id de la encuesta relacionada:"));   
                String tituloCapitulo = JOptionPane.showInputDialog(null, "Escriba el nombre de la Capitulo: ");

                Capitulo capitulo = new Capitulo(idEncuesta, tituloCapitulo);
                createCap.execute(capitulo);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delCap.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Capitulos:\n");
                List<Capitulo> Capitulos = allCap.execute();
                for (Capitulo capitulo : Capitulos) {

                    int id = capitulo.getId();
                    int idEncuesta = capitulo.getIdEncuesta();
                    Timestamp creadoEn = capitulo.getCreadoEn();
                    Timestamp actualizadoEn = capitulo.getActualizadoEn();
                    String numerocap =  capitulo.getNumeroCapitulo();
                    String titulo =  capitulo.getTituloCapitulo();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("id Encuesta: ").append(idEncuesta).append("\n")
                    .append("creado en: ").append(creadoEn).append("\n")
                    .append("actualizado en: ").append(actualizadoEn).append("\n")
                    .append("numero capitulo: ").append(numerocap).append("\n")
                    .append("titulo capitulo: ").append(titulo).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Capitulos", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Capitulo> dato = idCap.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Capitulos:\n");
                    if (dato.isPresent()) {
                        Capitulo datopre = dato.get();
                        int id = datopre.getId();
                        int idEncuesta = datopre.getIdEncuesta();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String numerocap =  datopre.getNumeroCapitulo();
                        String titulo =  datopre.getTituloCapitulo();


                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("id Encuesta: ").append(idEncuesta).append("\n")
                        .append("creado en: ").append(creadoEn).append("\n")
                        .append("actualizado en: ").append(actualizadoEn).append("\n")
                        .append("numero capitulo: ").append(numerocap).append("\n")
                        .append("titulo capitulo: ").append(titulo).append("\n\n");
        
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Capitulo> dato = idCap.execute(iduserupd);
                Capitulo CapituloUpd = dato.get();
                while (bandera) {
                    String opcionesUpd = """
                        1. id encuesta
                        2. titulo Capitulo
                        3. salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,4);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    CapituloUpd.setIdEncuesta(Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el nuevo id de la encuesta")));
                                    
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                } 
                                break;
                            case 2:
                                CapituloUpd.setTituloCapitulo(JOptionPane.showInputDialog(null," ingrese el titulo del Capitulo: "));
                                break;
                            case 3:
                                bandera = false;
                                break;
                            }
                        }
                } 
                updCap.execute(CapituloUpd);
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
