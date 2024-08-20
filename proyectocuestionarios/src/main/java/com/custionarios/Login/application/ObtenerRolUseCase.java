package com.custionarios.Login.application;

import java.util.Optional;

import com.custionarios.Login.domain.service.LoginService;

public class ObtenerRolUseCase {
    private LoginService loginService;

    public ObtenerRolUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<Integer> execute(int id){
        return loginService.roles(id);
    }
}
