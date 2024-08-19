package com.custionarios.capitulos.application;

import java.util.List;

import com.custionarios.capitulos.domain.entity.Capitulo;
import com.custionarios.capitulos.domain.service.CapituloService;

public class FindAllCapituloUseCase {
    private CapituloService capituloService;

    public FindAllCapituloUseCase(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public List<Capitulo> execute(){
        return capituloService.FindAllCapitulo();
    }

}
