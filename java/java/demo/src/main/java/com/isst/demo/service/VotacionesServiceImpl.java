package com.isst.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.VotacionesDTO;
import com.isst.demo.entity.Votaciones;
import com.isst.demo.repository.VotacionesRepository;
import com.isst.demo.service.VotacionesService;

@Service
public class VotacionesServiceImpl implements VotacionesService {
    @Autowired
    private VotacionesRepository VotacionesRepository;

    @Override
    public List<VotacionesDTO> listarVotaciones() {
        return VotacionesRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public VotacionesDTO crearVotacion(VotacionesDTO votacionDTO) {
    // Convertir DTO a entidad
    Votaciones votacion = new Votaciones();
    votacion.setDescripcion(votacionDTO.getDescripcion());
    votacion.setVotosFavor(0);  // Iniciar votos a favor en 0
    votacion.setVotosContra(0); // Iniciar votos en contra en 0
    votacion.setUsuariosVotantes(new HashSet<>()); // Inicializar lista de votantes

    // Guardar en la base de datos
    Votaciones votacionGuardada = VotacionesRepository.save(votacion);

    // Convertir la entidad guardada a DTO y devolverla
    return convertirADTO(votacionGuardada);
}


    @Override
    public VotacionesDTO votar(Long id, boolean favor, String usuario) {
        Votaciones votacion = VotacionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Votación no encontrada"));
        if (!votacion.getUsuariosVotantes().contains(usuario)) {
            if (favor) {
                votacion.setVotosFavor(votacion.getVotosFavor() + 1);
            } else {
                votacion.setVotosContra(votacion.getVotosContra() + 1);
            }
            votacion.getUsuariosVotantes().add(usuario);
            votacion = VotacionesRepository.save(votacion);
        }
        return convertirADTO(votacion);
    }

    private VotacionesDTO convertirADTO(Votaciones votacion) {
        VotacionesDTO dto = new VotacionesDTO();
        dto.setId(votacion.getId());
        dto.setDescripcion(votacion.getDescripcion());
        dto.setVotosFavor(votacion.getVotosFavor());
        dto.setVotosContra(votacion.getVotosContra());
        dto.setFechaCreacion(votacion.getFechaCreacion());
        // Suponiendo que el DTO y la entidad tienen los mismos campos
        return dto;
    }
    


}
