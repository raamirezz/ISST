package com.isst.demo.repository;

import com.isst.demo.entity.Registro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    Optional<Registro> findByUsuario(String usuario);
}
