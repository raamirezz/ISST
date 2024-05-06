package com.isst.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isst.demo.entity.Votaciones;

@Repository
public interface VotacionesRepository extends JpaRepository<Votaciones, Long> {

}
