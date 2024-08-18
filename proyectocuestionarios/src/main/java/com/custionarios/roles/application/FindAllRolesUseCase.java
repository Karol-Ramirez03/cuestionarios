package com.custionarios.roles.application;

import java.util.List;

import com.custionarios.roles.domain.entity.Roles;
import com.custionarios.roles.domain.service.RolesService;

public class FindAllRolesUseCase {
    private RolesService rolesService;

    public FindAllRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public List<Roles> execute() {
        return rolesService.FindAllRoles();
    }
}
