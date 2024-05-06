package com.isst.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.dto.ComentariosDTO;
import com.isst.demo.service.ComentariosService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/comentarios/")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    // Obtener todos los temas
    @GetMapping("/comentarios")
    public ResponseEntity<List<ComentariosDTO>> obtenerTodosLosComentarios() {
        List<ComentariosDTO> comentarios = comentariosService.obtenerTodosLosComentarios();
        return ResponseEntity.ok().body(comentarios);
    }

    // Obtener un tema por ID
    @GetMapping("/porTema/{temaId}")
public ResponseEntity<List<ComentariosDTO>> obtenerComentariosPorTemaId(@PathVariable Long temaId) {
    List<ComentariosDTO> comentarios = comentariosService.obtenerComentariosPorTemaId(temaId);
    return ResponseEntity.ok().body(comentarios);
}

    // Crear un nuevo tema
    @PostMapping("/crear")
    public ResponseEntity<ComentariosDTO> crearComentarios(@RequestBody ComentariosDTO comentariosDTO) {
        ComentariosDTO nuevoComentarios = comentariosService.crearComentario(comentariosDTO);
        return ResponseEntity.ok().body(nuevoComentarios);
    }

    @DeleteMapping("/eliminar/{id}")
public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    boolean deleted = comentariosService.eliminarComentario(id);
    if (deleted) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}

    

    

}
