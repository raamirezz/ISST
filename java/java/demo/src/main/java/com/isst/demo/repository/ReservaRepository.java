package com.isst.demo.repository;

import com.isst.demo.entity.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
