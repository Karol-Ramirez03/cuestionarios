package com.custionarios.capitulos.application;

import com.custionarios.capitulos.domain.service.CapituloService;

public class DeleteCapituloUseCase {
    private CapituloService capituloService;

    public DeleteCapituloUseCase(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(int id){
        capituloService.deleteCapitulo(id);
    }
}
