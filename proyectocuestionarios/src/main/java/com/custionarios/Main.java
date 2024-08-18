package com.custionarios;

import com.custionarios.usuarios.infrastructure.controtroller.ConsoleAdapterUsuario;

public class Main {
    public static void main(String[] args) {
        
        ConsoleAdapterUsuario cs = new ConsoleAdapterUsuario();
        cs.Start();
    }
}