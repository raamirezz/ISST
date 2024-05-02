package com.isst.demo.service;

import com.isst.demo.dto.ReservaDTO;

public interface ReservaService {

    void crearReserva(ReservaDTO reservaDTO);

    void actualizarDisponibilidad(ReservaDTO reservaDTO);
}
