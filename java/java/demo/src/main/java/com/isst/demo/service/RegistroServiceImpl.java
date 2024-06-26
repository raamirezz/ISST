package com.isst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


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

    public Registro consultarRegistroPorId(Long id){
        return registroRepository.findById(id).orElse(null);
    }

    public Registro findByUsername(String username) {
        return registroRepository.findByUsuario(username)
                                 .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre de usuario: " + username));
    }

    
    
}