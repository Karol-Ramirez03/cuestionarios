package com.custionarios;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.infrastructure.controller.ConsoleAdapterGenerarCuestionarios;
import com.custionarios.Login.infrastructure.controller.ConsoleAdapterLogin;
import com.custionarios.iuUsuarios.menuAdministracion;

public class Main {
    public static void main(String[] args) {

        // ConsoleAdapterLogin LOGIN = new ConsoleAdapterLogin();
        // LOGIN.Start();
    

        // ConsoleAdapterGenerarCuestionarios g = new ConsoleAdapterGenerarCuestionarios();
        // g.Start();

        
        menuAdministracion menu = new menuAdministracion();
        menu.Start();
    }                    
}