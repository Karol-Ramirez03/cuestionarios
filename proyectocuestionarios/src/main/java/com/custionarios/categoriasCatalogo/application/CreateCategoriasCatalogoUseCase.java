package com.custionarios.categoriasCatalogo.application;

import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;

public class CreateCategoriasCatalogoUseCase {
    private CategoriasCatalogoService categoriasCatalogoService;

    public CreateCategoriasCatalogoUseCase(CategoriasCatalogoService categoriasCatalogoService) {
        this.categoriasCatalogoService = categoriasCatalogoService;
    }

    public void execute(CategoriasCatalogo categoriasCatalogo) {
        categoriasCatalogoService.CreateCategoriasCatalogo(categoriasCatalogo);
    }
}
