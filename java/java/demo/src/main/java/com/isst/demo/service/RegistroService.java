package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.Registro;

public interface RegistroService {

    public void crearRegistroFormulario(RegistroDTO registroDTO);
    public Registro consultarRegistroPorId(Long id); 
}
