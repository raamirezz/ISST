package com.isst.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.isst.demo.dto.ComunidadDTO;
import com.isst.demo.entity.Comunidad;
import com.isst.demo.repository.ComunidadRepository;
import com.isst.demo.service.ComunidadService;

@Controller
public class CrearComunidadController {

    @Autowired
    private ComunidadService comunidadService; // Inyectar el servicio ComunidadService

    @GetMapping("/crear_comunidad")
    public String mostrarFormulario(Model model) {
        // Puedes agregar cualquier lógica adicional aquí, si es necesario
        return "crear_comunidad";
    }

    @PostMapping("/crear_comunidad")
    public String crearComunidad(@RequestParam int codigo,
            @RequestParam String calle,
            @RequestParam String provincia,
            @RequestParam List<String> instalaciones,
            Model model) {
        // Crear una nueva instancia de ComunidadDTO y asignar los valores
        ComunidadDTO comunidadDTO = new ComunidadDTO(codigo, calle, provincia, instalaciones);

        // Convertir ComunidadDTO a los parámetros esperados por el método
        // guardarComunidad
        int codigoComunidad = comunidadDTO.getCodigo();
        String calleComunidad = comunidadDTO.getCalle();
        String provinciaComunidad = comunidadDTO.getProvincia();
        List<String> instalacionesComunidad = comunidadDTO.getInstalaciones();

        // Llamar al método guardarComunidad del servicio para guardar la comunidad en
        // la base de datos
        comunidadService.guardarComunidad(codigoComunidad, calleComunidad, provinciaComunidad, instalacionesComunidad);

        // Por ahora, simplemente mostraremos un mensaje de éxito
        model.addAttribute("mensaje", "¡Comunidad creada exitosamente!");
        return "crear_comunidad";
    }

}
