package com.custionarios.capitulos.application;

import com.custionarios.capitulos.domain.entity.Capitulo;
import com.custionarios.capitulos.domain.service.CapituloService;

public class CreateCapituloUseCase {
    private CapituloService capituloService;

    public CreateCapituloUseCase(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulos){
        capituloService.CreateCapitulo(capitulos);
    }
}
