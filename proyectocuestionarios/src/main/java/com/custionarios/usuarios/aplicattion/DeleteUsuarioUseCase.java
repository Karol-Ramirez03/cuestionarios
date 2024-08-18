package com.custionarios.usuarios.aplicattion;

import com.custionarios.usuarios.domain.service.UsuarioService;

public class DeleteUsuarioUseCase {
    private UsuarioService usuarioService;

    public DeleteUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(int id){
        usuarioService.deleteUsuario(id);
    }
}
