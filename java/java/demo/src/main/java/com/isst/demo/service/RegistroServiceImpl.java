package com.isst.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.Registro;
import com.isst.demo.repository.RegistroRepository;

@Service
public class RegistroServiceImpl {

    @Autowired
    private RegistroRepository registroRepository;
   

    public void crearRegistroFormulario(RegistroDTO registroDTO) {
        // TODO Auto-generated method stub
        Registro registroEntity = new Registro(registroDTO);
        registroRepository.save(registroEntity);
    }

    public Registro consultarRegistro(){
        return registroRepository.findById(3L).get();
    }
    
}
