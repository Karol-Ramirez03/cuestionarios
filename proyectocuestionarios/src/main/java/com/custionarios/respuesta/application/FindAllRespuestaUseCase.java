package com.custionarios.respuesta.application;

import java.util.List;

import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;

public class FindAllRespuestaUseCase {
    private RespuestaService respuestaService;

    public FindAllRespuestaUseCase(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }
  
    public List<Respuesta> execute(){
        return respuestaService.FindAllRespuesta();
    }
}
