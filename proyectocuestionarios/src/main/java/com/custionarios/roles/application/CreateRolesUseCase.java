package com.custionarios.roles.application;

import com.custionarios.roles.domain.entity.Roles;
import com.custionarios.roles.domain.service.RolesService;

public class CreateRolesUseCase {
    private RolesService rolesService;

    public CreateRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(Roles roles){
        rolesService.CreateRoles(roles);
    }

}
