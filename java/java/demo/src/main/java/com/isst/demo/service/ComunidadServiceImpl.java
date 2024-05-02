package com.isst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.isst.demo.entity.Comunidad;
import com.isst.demo.repository.ComunidadRepository;

@Service
public class ComunidadServiceImpl implements ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Override
    public void guardarComunidad(int codigo, String calle, String provincia, List<String> instalaciones) {
        Comunidad comunidad = new Comunidad(codigo, calle, provincia, instalaciones);
        comunidadRepository.save(comunidad);
    }
}
