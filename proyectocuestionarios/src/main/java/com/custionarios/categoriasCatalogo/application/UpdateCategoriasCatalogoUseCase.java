package com.custionarios.categoriasCatalogo.application;

import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;

public class UpdateCategoriasCatalogoUseCase {
    private CategoriasCatalogoService categoriasCatalogoService;

    public UpdateCategoriasCatalogoUseCase(CategoriasCatalogoService categoriasCatalogoService) {
        this.categoriasCatalogoService = categoriasCatalogoService;
    }

    public void execute(CategoriasCatalogo categoriasCatalogo){
        categoriasCatalogoService.updateCategoriasCatalogo(categoriasCatalogo);
    }
}
