package com.isst.demo.repository;

import com.isst.demo.entity.Tema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TemaRepository extends CrudRepository<Tema, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
