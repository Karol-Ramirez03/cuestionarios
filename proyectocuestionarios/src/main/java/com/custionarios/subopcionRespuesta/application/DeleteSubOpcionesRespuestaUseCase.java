package com.custionarios.subopcionRespuesta.application;

import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class DeleteSubOpcionesRespuestaUseCase {
    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public DeleteSubOpcionesRespuestaUseCase(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(int id) {
        subOpcionesRespuestaService.deleteSubOpcionesRespuesta(id);
    }

}
