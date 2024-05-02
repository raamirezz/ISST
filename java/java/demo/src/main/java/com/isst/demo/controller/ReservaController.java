package com.isst.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.dto.ReservaDTO;
import com.isst.demo.service.ReservaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/reserva/")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Maneja las solicitudes POST para crear una nueva reserva
    @PostMapping("/crear")
    public String crearReserva(@RequestBody ReservaDTO reservaDTO) {
        reservaService.crearReserva(reservaDTO);
        return "Reserva creada exitosamente";
    }
    
    // Maneja las solicitudes PUT para actualizar la disponibilidad de una reserva existente
    @PutMapping("/actualizarDisponibilidad")
    public String actualizarDisponibilidad(@RequestBody ReservaDTO reservaDTO) {
        reservaService.actualizarDisponibilidad(reservaDTO);
        return "Estado de disponibilidad actualizado exitosamente";
    }
}
