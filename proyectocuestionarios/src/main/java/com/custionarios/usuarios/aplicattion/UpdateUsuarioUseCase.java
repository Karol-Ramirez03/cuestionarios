package com.custionarios.usuarios.aplicattion;

import com.custionarios.usuarios.domain.entity.Usuario;
import com.custionarios.usuarios.domain.service.UsuarioService;

public class UpdateUsuarioUseCase {
    private UsuarioService usuarioService;

    public UpdateUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario){
        usuarioService.updateUsuario(usuario);
    }
}
