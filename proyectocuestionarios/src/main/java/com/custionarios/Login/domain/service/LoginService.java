package com.custionarios.Login.domain.service;

import java.util.Optional;

import com.custionarios.Login.domain.entity.Login;

public interface LoginService { 
    public Optional<Integer> validarusuario(String user, String contraseña);
    public void guardarusuario(Login usuario); 
    public Optional<Integer> roles(int id);

}
