package com.isst.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.isst.demo.dto.VotacionesDTO;


public interface VotacionesService {
    List<VotacionesDTO> listarVotaciones();
    VotacionesDTO votar(Long id, boolean favor, String usuario);
    VotacionesDTO crearVotacion(VotacionesDTO votacionDTO);
}
