package com.custionarios.funciones;

import java.util.Optional;

import javax.swing.JOptionPane;

public class Validaciones {
    public static Optional<Integer> mostrarOpciones(String opciones,int min, int max) {
        

        while (true) {
     
            
            // Mostrar el menú con 6 opciones
            String seleccion = JOptionPane.showInputDialog(null, opciones, "Menú Principal", JOptionPane.QUESTION_MESSAGE);
            
            // Si el usuario presiona "Cancelar" o cierra la ventana
            if (seleccion == null) {
                int opcionSalir = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opcionSalir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                } else {
                    continue;
                }
            }
        
        // Verificar si la entrada es un número válido
        try {
            int opcion = Integer.parseInt(seleccion);
            if (opcion >= min && opcion <= max) {
                return Optional.of(opcion);
                
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un número que este entre el rango");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
        }
        
    }
    return Optional.empty();
}
    // public String cadenas_no_vacias(String dato){
    //     if (dato != null && !dato.trim().isEmpty()) {
    //         return dato;
    //     } else {
            
    //     }

    // }

}
