package com.isst.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/crear")
    public String crearReserva(@RequestBody ReservaDTO reservaDTO) {
        // Aquí puedes procesar los datos de la reserva y guardarlos en la base de datos
        reservaService.crearReserva(reservaDTO);
        // Devuelve un mensaje indicando que la reserva fue creada con éxito
        return "Reserva creada exitosamente";
    }
}
