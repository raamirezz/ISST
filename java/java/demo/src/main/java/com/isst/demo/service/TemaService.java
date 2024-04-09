package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.TemaDTO;
import com.isst.demo.entity.Tema;

public interface TemaService {

    public TemaDTO crearTema(TemaDTO temaDTO);
    public TemaDTO obtenerTemaPorId(Long id);
    public List<TemaDTO> obtenerTodosLosTemas();
    
}
