package com.custionarios.capitulos.application;

import com.custionarios.capitulos.domain.entity.Capitulo;
import com.custionarios.capitulos.domain.service.CapituloService;

public class UpdateCapituloUseCase {
    private CapituloService capituloService;

    public UpdateCapituloUseCase(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulo){
        capituloService.updateCapitulo(capitulo);
    }
}
