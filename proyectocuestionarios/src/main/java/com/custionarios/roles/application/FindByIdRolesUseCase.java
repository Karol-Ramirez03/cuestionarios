package com.custionarios.roles.application;

import java.util.Optional;

import com.custionarios.roles.domain.entity.Roles;
import com.custionarios.roles.domain.service.RolesService;

public class FindByIdRolesUseCase {
    private RolesService rolesService;

    public FindByIdRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public Optional<Roles> execute(int id) {
        return rolesService.FindByIdRoles(id);
    }

}
