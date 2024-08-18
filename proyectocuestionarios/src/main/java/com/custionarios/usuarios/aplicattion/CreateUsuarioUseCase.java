package com.custionarios.usuarios.aplicattion;

import com.custionarios.usuarios.domain.entity.Usuario;
import com.custionarios.usuarios.domain.service.UsuarioService;

public class CreateUsuarioUseCase {
    private UsuarioService usuarioService;

    public CreateUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario){
        usuarioService.CreateUsuario(usuario);
    }

}
