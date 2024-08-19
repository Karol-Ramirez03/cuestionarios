package com.custionarios.categoriasCatalogo.application;

import java.util.Optional;

import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;

public class FindByIdCategoriasCatalogoUseCase {
    private CategoriasCatalogoService categoriasCatalogoService;

    public FindByIdCategoriasCatalogoUseCase(CategoriasCatalogoService categoriasCatalogoService) {
        this.categoriasCatalogoService = categoriasCatalogoService;
    }

    public Optional<CategoriasCatalogo> execute(int id) {
        return categoriasCatalogoService.FindByIdCategoriasCatalogo(id);
    }
}
