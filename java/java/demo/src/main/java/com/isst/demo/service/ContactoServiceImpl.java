package com.isst.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.ContactoDTO;
import com.isst.demo.entity.Contacto;
import com.isst.demo.repository.ContactoRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;
   

    public void crearContactoFormulario(ContactoDTO contactoDTO) {
        // TODO Auto-generated method stub
        Contacto contactoEntity = new Contacto(contactoDTO);
        contactoRepository.save(contactoEntity);
    }

    public Contacto consultarContacto(){
        return contactoRepository.findById(3L).get();
    }
    
}