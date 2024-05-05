package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.ComunidadDTO;
import com.isst.demo.entity.Comunidad;

public interface ComunidadService {
    void guardarComunidad(ComunidadDTO comunidadDTO);

    List<Comunidad> obtenerTodasLasComunidades();
}