package com.custionarios.roles.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.roles.domain.entity.Roles;

public interface RolesService {
    public void CreateRoles(Roles roles);
    public void deleteRoles(int id);
    public void updateRoles(Roles roles);
    public List<Roles> FindAllRoles();
    public Optional<Roles> FindByIdRoles(int id);

}
