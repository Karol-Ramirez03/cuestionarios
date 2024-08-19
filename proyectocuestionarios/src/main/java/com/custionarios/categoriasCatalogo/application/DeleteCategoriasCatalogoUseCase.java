package com.custionarios.categoriasCatalogo.application;

import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;

public class DeleteCategoriasCatalogoUseCase {
    private CategoriasCatalogoService categoriasCatalogoService;

    public DeleteCategoriasCatalogoUseCase(CategoriasCatalogoService categoriasCatalogoService) {
        this.categoriasCatalogoService = categoriasCatalogoService;
    }

    public void execute(int id) {
        categoriasCatalogoService.deleteCategoriasCatalogo(id);
    }
}
