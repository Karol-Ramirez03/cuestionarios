package com.custionarios.usuarios.aplicattion;

import java.util.List;

import com.custionarios.usuarios.domain.entity.Usuario;
import com.custionarios.usuarios.domain.service.UsuarioService;

public class FindAllUsuarioUseCase {
    private UsuarioService usuarioService;

    public FindAllUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public List<Usuario> execute(){
        return usuarioService.FindAllUsuario();
    }

}
