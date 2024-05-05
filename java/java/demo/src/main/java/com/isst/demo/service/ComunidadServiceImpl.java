package com.isst.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isst.demo.dto.ComunidadDTO;
import com.isst.demo.entity.Comunidad;
import com.isst.demo.repository.ComunidadRepository;

@Service
public class ComunidadServiceImpl implements ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Override
    public void guardarComunidad(ComunidadDTO comunidadDTO) {
        Comunidad comunidad = new Comunidad();
        comunidad.setCommunityCode(comunidadDTO.getCommunityCode());
        comunidad.setCalle(comunidadDTO.getCalle());
        comunidad.setProvincia(comunidadDTO.getProvincia());
        // Asigna las instalaciones directamente al objeto Comunidad si es necesario
        // comunidad.setInstalaciones(comunidadDTO.getInstalaciones());

        comunidadRepository.save(comunidad);
    }

    @Override
    public List<Comunidad> obtenerTodasLasComunidades() {
        Iterable<Comunidad> iterable = comunidadRepository.findAll();
        List<Comunidad> comunidades = new ArrayList<>();
        iterable.forEach(comunidades::add);
        return comunidades;
    }

}