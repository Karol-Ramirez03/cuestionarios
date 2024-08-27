package com.custionarios.reportes.infrastructure.controller;

import java.awt.Dimension;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.reportes.application.ListarEncuestasUseCase;
import com.custionarios.reportes.application.MostrarOpcionesSubopcionesUseCase;
import com.custionarios.reportes.domain.entity.Reportes;
import com.custionarios.reportes.domain.service.ReportesService;
import com.custionarios.reportes.infrastructure.ReportesRepository.ReportesRepository;

public class ConsoleAdapterReportes {
    private Boolean bandera;
    private ReportesService reportesService;
    private ListarEncuestasUseCase listarEncuestas;
    private MostrarOpcionesSubopcionesUseCase mostrarReportes;


    
    public ConsoleAdapterReportes() {
        this.reportesService = new ReportesRepository();
        this.listarEncuestas = new ListarEncuestasUseCase(reportesService);
        this.mostrarReportes = new MostrarOpcionesSubopcionesUseCase(reportesService);
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
                bandera = false;
                return 0; 
            }
            if (opcion == JOptionPane.NO_OPTION) {
                bandera = false;
            }
            return opcion; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, introduce un número.");
            Start(); 
            return -1;
        }
    }

    // private String pregunta;
    // private String taxto_opcion;
    // private int cantidad_opcion;
    // private String texto_subopcion;
    // private int cantidad_subopcion;
    
    public void Start(){
        List<Reportes> listaEncuesta = listarEncuestas.execute();
        StringBuilder st = new StringBuilder();
        boolean bandera = true;
        for (Reportes reportes : listaEncuesta) {
            int id = reportes.getId();
            String nombre  = reportes.getNombre();

            st.append(id).append(" - ").append(nombre).append("\n");
        }
        st.append(listaEncuesta.size() + 1).append(" - ").append("salir").append("\n");

        while (bandera) { 
            String opcionstr = JOptionPane.showInputDialog(null,st);
            int idEncuesta = validarnumeros(listaEncuesta.size() + 1, opcionstr); 
            Optional<List<Reportes>> reporteMostrar = mostrarReportes.execute(idEncuesta);
            if (idEncuesta == 0 || idEncuesta == -1) {
                break;
            }
            
            if (reporteMostrar.isPresent()) {
                StringBuilder texto = new StringBuilder();
                String preguntaLast = "";
                List<Reportes> reporte = reporteMostrar.get();
                for (Reportes rp : reporte) {
                    String preguntaafter = rp.getPregunta();
                    String texto_opcion = rp.getTaxto_opcion();
                    int cantidad_opcion = rp.getCantidad_opcion();
                    String texto_subopcion = rp.getTexto_subopcion();
                    int cantidad_subopcion = rp.getCantidad_subopcion();
                    String textopreg = rp.getTexto();
                    System.out.println(texto_subopcion);
                    String text;
                    String opciones = "";
                    if (texto_subopcion == null) {
                        text = "sub opciones";
                    } else {
                        text = texto_subopcion;
                    }
                    if (texto_opcion == null) {
                        opciones = textopreg;
                    } else {
                        opciones = texto_opcion;
                    }

                    if (!preguntaLast.equals(preguntaafter)) {
                        texto.append("\n\n").append(preguntaafter).append("\n\n").append(opciones).append(" - ")
                        .append(cantidad_opcion).append("\n").append(text).append(" - ")
                        .append(cantidad_subopcion).append("\n");
                        preguntaLast = preguntaafter;
                    } else {
                        texto.append(opciones).append(" - ").append(cantidad_opcion)
                        .append("\n").append(text).append(" - ")
                        .append(cantidad_subopcion).append("\n");
                    }
                    
                }
                JTextArea textArea = new JTextArea(texto.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 
    
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                
                JOptionPane.showMessageDialog(null, scrollPane, "Respuestas de la Encuesta", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "esta en cuesta no tiene respuestas");
            }
            
        }
    }
    
}
