package com.custionarios.usuario_roles.application;

import com.custionarios.usuario_roles.domain.entity.UsuarioRol;
import com.custionarios.usuario_roles.domain.service.UsuarioRolService;

public class CreateUsuarioRolUseCase {
    private UsuarioRolService usuarioRolService;

    public CreateUsuarioRolUseCase(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public void execute(UsuarioRol usuarioRol){
        usuarioRolService.CreateUsuarioRol(usuarioRol);
    }

}
