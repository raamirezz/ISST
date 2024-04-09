package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.ComentariosDTO;

public interface ComentariosService {

    public ComentariosDTO crearComentario(ComentariosDTO ComentariosDTO);
    public ComentariosDTO obtenerComentariosPorId(Long id);
    public List<ComentariosDTO> obtenerTodosLosComentarios();
    
}
