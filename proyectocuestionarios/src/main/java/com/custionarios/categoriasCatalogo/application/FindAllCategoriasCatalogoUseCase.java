package com.custionarios.categoriasCatalogo.application;

import java.util.List;

import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;

public class FindAllCategoriasCatalogoUseCase {
    private CategoriasCatalogoService categoriasCatalogoService;

    public FindAllCategoriasCatalogoUseCase(CategoriasCatalogoService categoriasCatalogoService) {
        this.categoriasCatalogoService = categoriasCatalogoService;
    }

    public List<CategoriasCatalogo> execute(){
        return categoriasCatalogoService.FindAllCategoriasCatalogo();
    }
}
