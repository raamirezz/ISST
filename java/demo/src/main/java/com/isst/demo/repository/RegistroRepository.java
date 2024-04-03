package com.isst.demo.repository;

import com.isst.demo.entity.RegistroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RegistroRepository extends CrudRepository<RegistroEntity, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
