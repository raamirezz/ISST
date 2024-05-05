    package com.isst.demo.controller;

    import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.isst.demo.dto.ComentariosDTO;
import com.isst.demo.dto.TemaDTO;
import com.isst.demo.service.ComentariosService;
import com.isst.demo.service.TemaService;

    @Controller
    public class WebController {

        @Autowired
        private TemaService temaService;

        @Autowired
        private ComentariosService comentariosService;

        @GetMapping("/")
        public String home() {
            return "index";
        }

        @GetMapping("/admin")
        public String admin() {
            return "admin";
        }

        @GetMapping("/contacto")
        public String contacto() {
            return "contacto";
        }

        @GetMapping("/contacto_exitoso")
        public String contacto_exitoso() {
            return "contacto_exitoso";
        }

        @GetMapping("/perfil")
        public String perfil() {
            return "perfil";
        }

        @GetMapping("/registro_exitoso")
        public String registro_exitoso() {
            return "registro_exitoso";
        }

        @GetMapping("/reserva")
        public String reserva() {
            return "reserva";
        }

        @GetMapping("/votaciones")
        public String votaciones() {
            return "votaciones";
        }

        @GetMapping("/vecinos")
        public String vecinos() {
            return "vecinos";
        }

        @GetMapping("/foro")
        public String foro() {
            return "foro";
        }

        @GetMapping("/todos")
        public String todos() {
            return "todos";
        }

        @GetMapping("/registro")
        public String registro() {
            return "registro";
        }

        @GetMapping("/panel_admin")
        public String panel_admin() {
            return "panel_admin";
        }

        @GetMapping("/ver_comunidades")
        public String ver_comunidades() {
            return "ver_comunidades";
        }

        @GetMapping("/temaForo")
        public String getTemaForo(@RequestParam("id") Long id, Model model) {
            try {
                TemaDTO tema = temaService.obtenerTemaPorId(id);
                model.addAttribute("tema", tema);
                return "temaForo"; // El nombre 'temaForo' debe coincidir con el nombre del archivo HTML de la vista en tu carpeta de recursos
            } catch (Exception e) {
                model.addAttribute("error", "Tema no encontrado");
                return "error"; // Suponiendo que tienes una vista de error configurada
            }
        }

        @GetMapping("/tema/{temaId}")
    public ResponseEntity<?> getComentariosPorTema(@PathVariable Long temaId) {
        try {
            List<ComentariosDTO> comentarios = comentariosService.obtenerComentariosPorTemaId(temaId);
            if (comentarios == null) {
                comentarios = new ArrayList<>(); // Asegura que siempre se devuelva un array, incluso vacío
            }
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            // Loguea la excepción para diagnóstico y retorna un array vacío o un mensaje de error
            // Dependiendo del caso de uso, podrías querer devolver un HttpStatus específico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener comentarios: " + e.getMessage());
        }
    }

    }
