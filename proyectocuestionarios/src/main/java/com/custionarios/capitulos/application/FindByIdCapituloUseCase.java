package com.custionarios.capitulos.application;

import java.util.Optional;

import com.custionarios.capitulos.domain.entity.Capitulo;
import com.custionarios.capitulos.domain.service.CapituloService;

public class FindByIdCapituloUseCase {
    private CapituloService capituloService;

    public FindByIdCapituloUseCase(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public Optional<Capitulo> execute(int id){
        return capituloService.FindByIdCapitulo(id);
    }
}
