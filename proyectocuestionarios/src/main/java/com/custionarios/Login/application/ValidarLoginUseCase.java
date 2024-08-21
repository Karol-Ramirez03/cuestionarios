package com.custionarios.Login.application;

import java.util.Optional;

import com.custionarios.Login.domain.entity.Login;
import com.custionarios.Login.domain.service.LoginService;

public class ValidarLoginUseCase {
    private LoginService loginService;

    public ValidarLoginUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<Login> execute(String user, String contraseña){
        return loginService.validarusuario(user, contraseña);
    }
}
