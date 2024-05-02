package com.isst.demo.service;

import com.isst.demo.dto.ReservaDTO;
import com.isst.demo.entity.Reserva;
import com.isst.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public void crearReserva(ReservaDTO reservaDTO) {
        Reserva reserva = convertirReservaDTOa(reservaDTO);
        reservaRepository.save(reserva);
    }

    @Override
    public void actualizarDisponibilidad(ReservaDTO reservaDTO) {
        Reserva reserva = convertirReservaDTOa(reservaDTO);
        reservaRepository.save(reserva);
    }

    private Reserva convertirReservaDTOa(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setDisponible(reservaDTO.isDisponible());
        reserva.setFecha(reservaDTO.getFecha());
        reserva.setHora(reservaDTO.getHora());
        reserva.setTipoInstalacion(reservaDTO.getTipoInstalacion());
        reserva.setUsuario(reservaDTO.getUsuario());
        return reserva;
    }
}
