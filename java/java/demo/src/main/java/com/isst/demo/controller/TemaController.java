package com.isst.demo.controller;

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

import com.isst.demo.dto.TemaDTO;
import com.isst.demo.service.TemaService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/tema/")
public class TemaController {

    @Autowired
    private TemaService temaService;

    // Obtener todos los temas
    @GetMapping("/temas")
    public ResponseEntity<List<TemaDTO>> obtenerTodosLosTemas() {
        List<TemaDTO> temas = temaService.obtenerTodosLosTemas();
        return ResponseEntity.ok().body(temas);
    }

    // Obtener un tema por ID
    @GetMapping("/{id}")
    public ResponseEntity<TemaDTO> obtenerTemaPorId(@PathVariable Long id) {
        TemaDTO tema = temaService.obtenerTemaPorId(id);
        return ResponseEntity.ok().body(tema);
    }

    // Crear un nuevo tema
    @PostMapping("/crear")
    public ResponseEntity<TemaDTO> crearTema(@RequestBody TemaDTO temaDTO) {
        TemaDTO nuevoTema = temaService.crearTema(temaDTO);
        return ResponseEntity.ok().body(nuevoTema);
    }

    @DeleteMapping("/eliminar/{id}")
public ResponseEntity<Void> eliminarTema(@PathVariable Long id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    boolean deleted = temaService.eliminarTema(id);
    if (deleted) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
