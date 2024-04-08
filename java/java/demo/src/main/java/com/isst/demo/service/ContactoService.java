package com.isst.demo.service;

import java.util.List;

import com.isst.demo.dto.ContactoDTO;
import com.isst.demo.entity.Contacto;

public interface ContactoService {

    public void crearContactoFormulario (ContactoDTO contactoDTO);
    public Contacto consultarContacto();
    
}
