package com.custionarios.iuUsuarios;

import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
import com.custionarios.categoriasCatalogo.infrastructure.controller.ConsoleAdapterCategoriasCatalogo;
import com.custionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;
import com.custionarios.funciones.Validaciones;
import com.custionarios.opcionesRespuestas.infrastructure.controller.ConsoleAdapterOpcionesRespuesta;
import com.custionarios.preguntas.infrastructure.controller.ConsoleAdapterPregunta;
import com.custionarios.reportes.infrastructure.controller.ConsoleAdapterReportes;
import com.custionarios.respuesta.infrastructure.controller.ConsoleAdapterRespuesta;
import com.custionarios.roles.infrastructure.controller.ConsoleAdapterRoles;
import com.custionarios.subopcionRespuesta.infrastruture.controller.ConsoleAdapterSubOpcionesRespuesta;
import com.custionarios.usuario_roles.infrastructure.controller.ConsoleAdapterUsuarioRol;
import com.custionarios.usuarios.infrastructure.controtroller.ConsoleAdapterUsuario;

public class menuAdministracion {

        public void Start(){
            String opciones = """
                    1. Administrar clientes
                    2. Administrar Usuarios-Rol
                    3. Administrar Roles
                    4. Administrar SubOpciones
                    5. Administrar Respuestas
                    6. Administrar Preguntas
                    7. Administrar Opciones 
                    8. Administrar Encuestas
                    9. Administrar Categorias
                    10. Administrar Capitulos
                    11. Ver Reportes
                    12. salir
                    """;
        Optional<Integer> opcion = Validaciones.mostrarOpciones(opciones,1,12);

        if (opcion.isPresent()) {
            int numero = opcion.get();
            ejecutarOpcion(numero);
        } 
    }
    public void ejecutarOpcion(int numero){
        switch (numero) {
            case 1:
                ConsoleAdapterUsuario menuClientes = new ConsoleAdapterUsuario();
                menuClientes.Start();
                Start();
                break;

            case 2:
                ConsoleAdapterUsuarioRol menuUsuarioRol = new ConsoleAdapterUsuarioRol();
                menuUsuarioRol.Start();
                Start();
                break;
            case 3:
                ConsoleAdapterRoles menuRoles = new ConsoleAdapterRoles();
                menuRoles.Start();
                Start();
                break;
            case 4:
                ConsoleAdapterSubOpcionesRespuesta menuSubOpciones = new ConsoleAdapterSubOpcionesRespuesta();
                menuSubOpciones.Start();
                Start();
                break;
            case 5:
                ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
                menuRespuesta.Start();
                Start();
                
                break;
            case 6:
                ConsoleAdapterPregunta menuPregunta = new ConsoleAdapterPregunta();
                menuPregunta.Start();
                Start();
                break;
            case 7:
                ConsoleAdapterOpcionesRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpcionesRespuesta();
                menuOpcionesRespuesta.Start();
                Start();
                break;
            case 8:
                ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
                menuEncuesta.Start();
                Start();
                break;
            case 9:
                ConsoleAdapterCategoriasCatalogo menuCatalogo = new ConsoleAdapterCategoriasCatalogo();
                menuCatalogo.Start();
                Start();
                break;
            case 10:
                ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
                menuCapitulo.Start();
                Start();
                
                break;
            case 11:
                ConsoleAdapterReportes reportes = new ConsoleAdapterReportes();
                reportes.Start();
                Start();
                break;
            case 12:
                JOptionPane.showMessageDialog(null, "Saliendo Del Programa");
                break;
        
            default:
                break;
        }

    }
}
