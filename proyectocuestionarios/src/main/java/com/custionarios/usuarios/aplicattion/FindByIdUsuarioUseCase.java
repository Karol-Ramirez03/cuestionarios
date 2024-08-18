package com.custionarios.usuarios.aplicattion;

import java.util.Optional;

import com.custionarios.usuarios.domain.entity.Usuario;
import com.custionarios.usuarios.domain.service.UsuarioService;

public class FindByIdUsuarioUseCase {
    private UsuarioService usuarioService;

    public FindByIdUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public Optional<Usuario> execute(int id){
        return usuarioService.FindByIdUsuario(id);
    }
}
