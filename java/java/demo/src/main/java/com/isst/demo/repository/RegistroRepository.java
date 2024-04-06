package com.isst.demo.repository;

import com.isst.demo.entity.Registro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RegistroRepository extends CrudRepository<Registro, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
