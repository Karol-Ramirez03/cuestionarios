package com.custionarios.usuario_roles.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.usuario_roles.domain.entity.UsuarioRol;

public interface UsuarioRolService {
    public void CreateUsuarioRol(UsuarioRol UsuarioRol);
    public void deleteUsuarioRol(int idROL, int idUSER);
    public void updateUsuarioRol(UsuarioRol UsuarioRol);
    public List<UsuarioRol> FindAllUsuarioRol();
    public Optional<UsuarioRol> FindByIdUsuarioRol(int idUSER);
}
