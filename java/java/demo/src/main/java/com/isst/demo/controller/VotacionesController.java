package com.isst.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.isst.demo.dto.VotacionesDTO;
import com.isst.demo.dto.VotoDTO;
import com.isst.demo.service.VotacionesService;

@RestController
@RequestMapping("/api/votaciones")
public class VotacionesController {
    @Autowired
    private VotacionesService votacionesService;

    @GetMapping("/votaciones")
    public ResponseEntity<List<VotacionesDTO>> obtenerVotaciones() {
        return ResponseEntity.ok(votacionesService.listarVotaciones());
    }

    @PostMapping("/votar/{id}")
public ResponseEntity<VotacionesDTO> votar(@PathVariable Long id, @RequestBody VotoDTO voto) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String usuario = auth.getName();
    if (voto.getVoto() != null) {
        return ResponseEntity.ok(votacionesService.votar(id, voto.getVoto(), usuario));
    } else {
        // Manejo de error si el voto es nulo
        return ResponseEntity.badRequest().build(); // O manejar de otra manera
    }
}






    @PostMapping("/crear")
    public ResponseEntity<VotacionesDTO> crearVotacion(@RequestBody VotacionesDTO nuevaVotacion) {
    VotacionesDTO votacionCreada = votacionesService.crearVotacion(nuevaVotacion);
    return ResponseEntity.ok(votacionCreada);
}
}
