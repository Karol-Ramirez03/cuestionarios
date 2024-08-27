package com.custionarios.Login.infrastructure.controller;

import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.GenerarCuestionarios.infrastructure.controller.ConsoleAdapterGenerarCuestionarios;
import com.custionarios.Login.application.IngresarUsuarioUseCase;
import com.custionarios.Login.application.ObtenerRolUseCase;
import com.custionarios.Login.application.ValidarLoginUseCase;
import com.custionarios.Login.domain.entity.Login;
import com.custionarios.Login.domain.service.LoginService;
import com.custionarios.Login.infrastructure.repository.LoginRepository;
import com.custionarios.funciones.Validaciones;
import com.custionarios.iuUsuarios.menuAdministracion;
import com.custionarios.reportes.infrastructure.controller.ConsoleAdapterReportes;

public class ConsoleAdapterLogin {
    private LoginService loginService;
    private IngresarUsuarioUseCase ingresar;
    private ValidarLoginUseCase validar;
    private ObtenerRolUseCase obtenerRol;

    


    public ConsoleAdapterLogin() {
        this.loginService = new LoginRepository();
        this.ingresar = new IngresarUsuarioUseCase(loginService);
        this.validar = new ValidarLoginUseCase(loginService);
        this.obtenerRol = new ObtenerRolUseCase(loginService);
    }

    // reescribir el codigo si el usuario esta habilitado o no
    public void Start(){
        String user = JOptionPane.showInputDialog(null, "igrese el usuario");
        String password = JOptionPane.showInputDialog(null, "ingrese la contraseña");
        Optional<Login> iduser = validar.execute(user, password);
        if (iduser.isPresent()) {
            Login usuario = iduser.get();
            int idusuario = usuario.getIdrol();
            boolean habilitado = usuario.isIdhabilitado();
            Optional<Integer> idrol = obtenerRol.execute(idusuario);
            if (idrol.isPresent()) {
                int rol = idrol.get();
                if (rol == 1  && habilitado == true) {
                    menuAdministracion menuCrud = new menuAdministracion();
                    menuCrud.Start();
                    
                } 
                if (rol != 1 && habilitado == true) {
                    String menu = """
                            1. ver reportes
                            2. hacer Encuestas
                            3. salir
                            """;
                    Optional<Integer> opciones = Validaciones.mostrarOpciones(menu, 1, 3);
                    if (opciones.isPresent()) {
                        int opcion = opciones.get();
                        switch (opcion) {
                            case 1:
                                ConsoleAdapterReportes reportes = new ConsoleAdapterReportes();
                                reportes.Start();
                                
                                break;
                            case 2:
                                ConsoleAdapterGenerarCuestionarios encuesta = new ConsoleAdapterGenerarCuestionarios();
                                encuesta.Start();
                                break;
                            case 3:
                                return;
                            default:
                                System.out.println("Opción no válida. Por favor, elija 1 o 2.");
                        }
                        
                    }
        
        
                }
                if (habilitado == false) {
                    JOptionPane.showMessageDialog(null,"Lo siento, no estas Habilitado");
                    Start();
                } 
            }

        } else {
            int response = JOptionPane.showConfirmDialog(null, "¿Deseas agregar ese nuevo usuario?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                Login login = new Login(password, user);
                ingresar.execute(login);
                Start();
            } else if (response == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "saliendo del programa...");
            }
            
        }
    }

}
