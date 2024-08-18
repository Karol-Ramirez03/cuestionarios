package com.custionarios.usuario_roles.application;

import com.custionarios.usuario_roles.domain.entity.UsuarioRol;
import com.custionarios.usuario_roles.domain.service.UsuarioRolService;

public class UpdateUsuarioRolUseCase {
    private UsuarioRolService usuarioRolService;

    public UpdateUsuarioRolUseCase(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }
    
    public void execute(UsuarioRol usuarioRol) {
        usuarioRolService.updateUsuarioRol(usuarioRol);
    }

}
