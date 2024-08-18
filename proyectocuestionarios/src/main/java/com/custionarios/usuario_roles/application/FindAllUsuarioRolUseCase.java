package com.custionarios.usuario_roles.application;

import java.util.List;

import com.custionarios.usuario_roles.domain.entity.UsuarioRol;
import com.custionarios.usuario_roles.domain.service.UsuarioRolService;

public class FindAllUsuarioRolUseCase {
    private UsuarioRolService usuarioRolService;

    public FindAllUsuarioRolUseCase(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public List<UsuarioRol> execute(){
        return usuarioRolService.FindAllUsuarioRol();
    }

}
