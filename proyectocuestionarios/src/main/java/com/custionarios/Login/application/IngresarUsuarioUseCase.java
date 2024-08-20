package com.custionarios.Login.application;

import com.custionarios.Login.domain.entity.Login;
import com.custionarios.Login.domain.service.LoginService;

public class IngresarUsuarioUseCase {
    private LoginService loginService;

    public IngresarUsuarioUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public void execute(Login usuario){
        loginService.guardarusuario(usuario);
    }

}
