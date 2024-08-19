package com.custionarios;

import com.custionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;
import com.custionarios.opcionesRespuestas.infrastructure.controller.ConsoleAdapterOpcionesRespuesta;
import com.custionarios.preguntas.infrastructure.controller.ConsoleAdapterPregunta;
import com.custionarios.respuesta.infrastructure.controller.ConsoleAdapterRespuesta;
import com.custionarios.roles.infrastructure.controller.ConsoleAdapterRoles;
import com.custionarios.subopcionRespuesta.infrastruture.controller.ConsoleAdapterSubOpcionesRespuesta;
import com.custionarios.usuario_roles.infrastructure.controller.ConsoleAdapterUsuarioRol;
import com.custionarios.usuarios.infrastructure.controtroller.ConsoleAdapterUsuario;

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

        ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
        menuEncuesta.Start();
    }                      
}