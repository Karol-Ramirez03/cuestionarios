package com.custionarios.usuario_roles.application;

import java.util.Optional;

import com.custionarios.usuario_roles.domain.entity.UsuarioRol;
import com.custionarios.usuario_roles.domain.service.UsuarioRolService;

public class FindByIdUsuarioRolUseCase {
    private UsuarioRolService usuarioRolService;

    public FindByIdUsuarioRolUseCase(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public Optional<UsuarioRol> execute(int id2){
        return usuarioRolService.FindByIdUsuarioRol(id2);
    }

}
