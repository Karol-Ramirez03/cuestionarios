package com.custionarios.usuarios.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.usuarios.domain.entity.Usuario;

public interface UsuarioService {
    public void CreateUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void updateUsuario(Usuario usuario);
    public List<Usuario> FindAllUsuario();
    public Optional<Usuario> FindByIdUsuario(int id);

}
