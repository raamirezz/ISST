package com.isst.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isst.demo.entity.Comentarios;


public interface ComentariosRepository extends CrudRepository<Comentarios, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
    List<Comentarios> findByTemaId(Long temaId);
}
