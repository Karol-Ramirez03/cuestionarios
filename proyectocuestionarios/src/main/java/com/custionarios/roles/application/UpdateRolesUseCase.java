package com.custionarios.roles.application;

import com.custionarios.roles.domain.entity.Roles;
import com.custionarios.roles.domain.service.RolesService;

public class UpdateRolesUseCase {
    private RolesService rolesService;

    public UpdateRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(Roles roles){
        rolesService.updateRoles(roles);
    }
}
