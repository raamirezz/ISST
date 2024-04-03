package com.isst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.RegistroEntity;
import com.isst.demo.repository.RegistroRepository;

@Service
public class RegistroServiceImpl {

    @Autowired
    private RegistroRepository registroRepository;
   

    public void crearRegistroFormulario(RegistroDTO registroDTO) {
        // TODO Auto-generated method stub
        RegistroEntity registroEntity = new RegistroEntity(1l, "Armando", "armando@rgthr");
        registroRepository.save(registroEntity);
    }
    
}
