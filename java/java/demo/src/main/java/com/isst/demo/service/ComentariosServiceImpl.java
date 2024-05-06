package com.isst.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.ComentariosDTO;
import com.isst.demo.dto.TemaDTO;
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

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        return comentarios.stream()
                .map(comentario -> {
                    ComentariosDTO comentariosDTO = modelMapper.map(comentario, ComentariosDTO.class);
                    // Establece la capacidad de eliminar basada en si el usuario es admin
                    comentariosDTO.setCanDelete(isAdmin);
                    return comentariosDTO;
                })
                .collect(Collectors.toList());
    }

    
    @Override
public ComentariosDTO crearComentario(ComentariosDTO comentariosDTO) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName(); // Obtiene el nombre de usuario del contexto de seguridad

    Tema tema = temaRepository.findById(comentariosDTO.getTemaId())
            .orElseThrow(() -> new RuntimeException("Tema no encontrado con id: " + comentariosDTO.getTemaId()));
    
    Comentarios comentario = modelMapper.map(comentariosDTO, Comentarios.class);
    comentario.setTema(tema);
    comentario.setUsuario(username); // Usa el nombre de usuario autenticado

    Comentarios nuevoComentario = ComentariosRepository.save(comentario);
    return modelMapper.map(nuevoComentario, ComentariosDTO.class);
}


    @Override
public List<ComentariosDTO> obtenerComentariosPorTemaId(Long temaId) {
    List<Comentarios> comentarios = ComentariosRepository.findByTemaId(temaId);
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = authentication.getAuthorities().stream()
                                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

    return comentarios.stream()
                      .map(comentario -> {
                          ComentariosDTO comentariosDTO = modelMapper.map(comentario, ComentariosDTO.class);
                          comentariosDTO.setCanDelete(isAdmin);
                          comentariosDTO.setNombreUsuario(comentario.getTema().getUsuario()); // Suponiendo que tienes acceso al nombre de usuario desde la entidad Tema
                          return comentariosDTO;
                      })
                      .collect(Collectors.toList());
}


@Override
    public boolean eliminarComentario(Long id) {
        try {
            ComentariosRepository.deleteById(id);
            return true;  // Assuming deleteById does not throw an exception
        } catch (Exception e) {
            return false; // Handle the case where deletion is unsuccessful
        }
    }


    
}