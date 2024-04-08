package com.isst.demo.repository;

import com.isst.demo.entity.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ContactoRepository extends CrudRepository<Contacto, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
