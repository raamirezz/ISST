package com.isst.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @GetMapping("/{id}")
    public ResponseEntity<ComentariosDTO> obtenerComentariosPorId(@PathVariable Long id) {
        ComentariosDTO comentario = comentariosService.obtenerComentariosPorId(id);
        return ResponseEntity.ok().body(comentario);
    }

    // Crear un nuevo tema
    @PostMapping("/crear")
    public ResponseEntity<ComentariosDTO> crearComentarios(@RequestBody ComentariosDTO comentariosDTO) {
        ComentariosDTO nuevoComentarios = comentariosService.crearComentario(comentariosDTO);
        return ResponseEntity.ok().body(nuevoComentarios);
    }

    

}
