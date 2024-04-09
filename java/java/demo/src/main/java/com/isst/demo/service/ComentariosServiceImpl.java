package com.isst.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.ComentariosDTO;
import com.isst.demo.entity.Comentarios;
import com.isst.demo.entity.Tema;
import com.isst.demo.repository.ComentariosRepository;
import com.isst.demo.repository.TemaRepository;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosRepository ComentariosRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ComentariosDTO> obtenerTodosLosComentarios() {
    List<Comentarios> comentarios = new ArrayList<>();
    ComentariosRepository.findAll().forEach(comentarios::add);

        return comentarios.stream()
                    .map(comentario -> modelMapper.map(comentario, ComentariosDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public ComentariosDTO obtenerComentariosPorId(Long id) {
        Comentarios comentario = ComentariosRepository.findById(id).orElseThrow(() -> new RuntimeException("comentario no encontrado"));
        return modelMapper.map(comentario, ComentariosDTO.class);
    }

    @Override
    public ComentariosDTO crearComentario(ComentariosDTO comentariosDTO) {
        Tema tema = temaRepository.findById(comentariosDTO.getTemaId())
                .orElseThrow(() -> new RuntimeException("Tema no encontrado con id: " + comentariosDTO.getTemaId()));
        
        Comentarios comentario = modelMapper.map(comentariosDTO, Comentarios.class);
        comentario.setTema(tema); // Establecer el tema asociado al comentario
        
        Comentarios nuevoComentario = ComentariosRepository.save(comentario);
        return modelMapper.map(nuevoComentario, ComentariosDTO.class);
    }

    
}