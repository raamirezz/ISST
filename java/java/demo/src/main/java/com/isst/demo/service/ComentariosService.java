package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.ComentariosDTO;

public interface ComentariosService {

    public ComentariosDTO crearComentario(ComentariosDTO ComentariosDTO);
    public List<ComentariosDTO> obtenerTodosLosComentarios();
    public List<ComentariosDTO> obtenerComentariosPorTemaId(Long temaId);
    public boolean eliminarComentario(Long id);
    
}
