package com.custionarios.categoriasCatalogo.domain.service;

import java.util.List;
import java.util.Optional;

import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;


public interface CategoriasCatalogoService {
    public void CreateCategoriasCatalogo(CategoriasCatalogo categoriasCatalogo);
    public void deleteCategoriasCatalogo(int id);
    public void updateCategoriasCatalogo(CategoriasCatalogo categoriasCatalogo);
    public List<CategoriasCatalogo> FindAllCategoriasCatalogo();
    public Optional<CategoriasCatalogo> FindByIdCategoriasCatalogo(int id);
    
} 