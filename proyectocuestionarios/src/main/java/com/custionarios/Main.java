package com.custionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import java.awt.GridLayout;

import com.custionarios.GenerarCuestionarios.infrastructure.controller.ConsoleAdapterGenerarCuestionarios;
// import com.custionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
// import com.custionarios.categoriasCatalogo.infrastructure.controller.ConsoleAdapterCategoriasCatalogo;
// import com.custionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;
// import com.custionarios.opcionesRespuestas.infrastructure.controller.ConsoleAdapterOpcionesRespuesta;
// import com.custionarios.preguntas.infrastructure.controller.ConsoleAdapterPregunta;
// import com.custionarios.respuesta.infrastructure.controller.ConsoleAdapterRespuesta;
// import com.custionarios.roles.infrastructure.controller.ConsoleAdapterRoles;
// import com.custionarios.subopcionRespuesta.infrastruture.controller.ConsoleAdapterSubOpcionesRespuesta;
// import com.custionarios.usuario_roles.infrastructure.controller.ConsoleAdapterUsuarioRol;
// import com.custionarios.usuarios.infrastructure.controtroller.ConsoleAdapterUsuario;

public class Main {
    public static void main(String[] args) {
        
        // ConsoleAdapterUsuario cs = new ConsoleAdapterUsuario();
        // cs.Start();

        // ConsoleAdapterUsuarioRol caur = new ConsoleAdapterUsuarioRol();
        // caur.Start();

        // ConsoleAdapterRoles car = new ConsoleAdapterRoles();
        // car.Start();

        // ConsoleAdapterSubOpcionesRespuesta casor = new ConsoleAdapterSubOpcionesRespuesta();
        // casor.Start();

        // ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
        // menuRespuesta.Start();

        // ConsoleAdapterPregunta menuPregunta = new ConsoleAdapterPregunta();
        // menuPregunta.Start();

        // ConsoleAdapterOpcionesRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpcionesRespuesta();
        // menuOpcionesRespuesta.Start();

        // ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
        // menuEncuesta.Start();

        // ConsoleAdapterCategoriasCatalogo menuCatalogo = new ConsoleAdapterCategoriasCatalogo();
        // menuCatalogo.Start();

        // ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
        // menuCapitulo.Start();

        ConsoleAdapterGenerarCuestionarios encuesta = new ConsoleAdapterGenerarCuestionarios();
        encuesta.Start();

    }                    
}