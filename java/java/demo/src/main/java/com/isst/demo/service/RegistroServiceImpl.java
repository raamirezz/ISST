package com.isst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.Registro;
import com.isst.demo.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements RegistroService{

    @Autowired
    private RegistroRepository registroRepository;
   
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void crearRegistroFormulario(RegistroDTO registroDTO) {
        // TODO Auto-generated method stub
        String encodedPassword = passwordEncoder.encode(registroDTO.getContraseña());
        registroDTO.setContraseña(encodedPassword);
        
        Registro registroEntity = new Registro(registroDTO);
        registroRepository.save(registroEntity);
    }

    public Registro consultarRegistro(){
        return registroRepository.findById(3L).get();
    }
    
}