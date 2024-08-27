package com.custionarios;

import com.custionarios.Login.infrastructure.controller.ConsoleAdapterLogin;
import com.custionarios.reportes.infrastructure.controller.ConsoleAdapterReportes;

public class Main {
    public static void main(String[] args) {

        ConsoleAdapterLogin LOGIN = new ConsoleAdapterLogin();
        LOGIN.Start();

        // ConsoleAdapterReportes reportes = new ConsoleAdapterReportes();
        // reportes.Start();

        
    }                    
}