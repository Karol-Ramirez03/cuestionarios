package com.custionarios.Login.infrastructure.controller;

import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Login.application.IngresarUsuarioUseCase;
import com.custionarios.Login.application.ObtenerRolUseCase;
import com.custionarios.Login.application.ValidarLoginUseCase;
import com.custionarios.Login.domain.entity.Login;
import com.custionarios.Login.domain.service.LoginService;
import com.custionarios.Login.infrastructure.repository.LoginRepository;

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
        Optional<Integer> iduser = validar.execute(user, password);
        if (iduser.isPresent()) {
            int idusuario = iduser.get();
            Optional<Integer> idrol = obtenerRol.execute(idusuario);
            if (idrol.isPresent()) {
                int rol = idrol.get();
                if (rol == 1 ) {
                    // funcion para visualizar el crud
                    
                } else {
                    // funcion para encuestas
                }
            }

        } else {
            int response = JOptionPane.showConfirmDialog(null, "¿Deseas agregar ese nuevo usuario?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                Login login = new Login(password, user);
                ingresar.execute(login);
            } else if (response == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "saliendo del programa...");
            }
            
        }
    }

}
