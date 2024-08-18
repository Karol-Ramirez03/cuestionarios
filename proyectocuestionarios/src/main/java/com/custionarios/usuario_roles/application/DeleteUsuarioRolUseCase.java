package com.custionarios.usuario_roles.application;

import com.custionarios.usuario_roles.domain.service.UsuarioRolService;

public class DeleteUsuarioRolUseCase {
    private UsuarioRolService usuarioRolService;

    public DeleteUsuarioRolUseCase(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public void execute(int id_rol, int id_usuario){
        usuarioRolService.deleteUsuarioRol(id_rol, id_usuario);
    }

}
