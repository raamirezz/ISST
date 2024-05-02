package com.isst.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isst.demo.entity.Comunidad;

@Repository
public interface ComunidadRepository extends CrudRepository<Comunidad, Long> {
    List<Comunidad> findByCodigo(int codigo);
}
