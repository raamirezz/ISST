package com.isst.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.dto.ComunidadDTO;
import com.isst.demo.entity.Comunidad;
import com.isst.demo.service.ComunidadService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("api/comunidad/")
public class ComunidadController {

    @Autowired
    private ComunidadService comunidadService;

    @PostMapping("/crear_comunidad")
    public String crearComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        // Procesa los datos de la comunidad recibidos en el DTO
        comunidadService.guardarComunidad(comunidadDTO);
        // Devuelve un mensaje indicando que la comunidad fue creada con Ã©xito
        return "Comunidad creada exitosamente";
    }

    @GetMapping("/todas")
    public List<Comunidad> obtenerTodasLasComunidades() {
        return comunidadService.obtenerTodasLasComunidades();
    }
}