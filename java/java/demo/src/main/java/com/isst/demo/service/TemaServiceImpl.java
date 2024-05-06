package com.isst.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;


import com.isst.demo.dto.TemaDTO;
import com.isst.demo.entity.Registro;
import com.isst.demo.entity.Tema;
import com.isst.demo.repository.RegistroRepository;
import com.isst.demo.repository.TemaRepository;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ModelMapper modelMapper;

    // @Override
    // public List<TemaDTO> obtenerTodosLosTemas() {
    //     List<Tema> temas = new ArrayList<>();
    //     temaRepository.findAll().forEach(temas::add);

    //     return temas.stream()
    //                 .map(tema -> modelMapper.map(tema, TemaDTO.class))
    //                 .collect(Collectors.toList());
    // }

    @Override
public List<TemaDTO> obtenerTodosLosTemas() {
    List<Tema> temas = new ArrayList<>();
    temaRepository.findAll().forEach(temas::add);

    // Obtiene la autenticación actual y verifica si el usuario tiene el rol 'ROLE_ADMIN'
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

    return temas.stream()
                .map(tema -> {
                    TemaDTO temaDTO = modelMapper.map(tema, TemaDTO.class);
                    // Establece la capacidad de eliminar basada en si el usuario es admin
                    temaDTO.setCanDelete(isAdmin);
                    if (tema.getUsuario() != null) {
                        temaDTO.setNombreUsuario(tema.getUsuario()); // Here usuario should be the username
                    }
                    return temaDTO;
                })
                .collect(Collectors.toList());
}

@Override
public TemaDTO obtenerTemaPorId(Long id) {
    Tema tema = temaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tema no encontrado"));
    TemaDTO temaDTO = modelMapper.map(tema, TemaDTO.class);
    if (tema.getUsuario() != null) {
        temaDTO.setNombreUsuario(tema.getUsuario()); // Asegúrate de que esto está correcto
    }
    return temaDTO;
}


    @Override
    public TemaDTO crearTema(TemaDTO temaDTO) {
        // Convertir DTO a entidad
        Tema tema = modelMapper.map(temaDTO, Tema.class);
        String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        // Registro nombre = registroRepository.findByUsuario(nombreUsuario);
        // if (nombre == null) {
        //     throw new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario);
        // }
        // Guardar entidad
        tema.setUsuario(nombreUsuario);
        tema = temaRepository.save(tema);
        // Verificar si el tema es importante y enviar correo
        if (Boolean.TRUE.equals(tema.getIsImportant())) {
            Iterable<Registro> iterable = registroRepository.findAll();
            List<Registro> registros = new ArrayList<>();
            for (Registro registro : iterable) {
                registros.add(registro);
            }
            // Suponiendo que cada Registro tiene un método getEmail()
            for (Registro registro : registros) {
                emailService.sendEmail(registro.getEmail(), "Tema Importante TuComunidad", "Se ha creado un tema importante: " + tema.getTitulo());
            }
        }
        // Convertir la entidad guardada de vuelta a DTO
        return modelMapper.map(tema, TemaDTO.class);
    }

    @Override
    public boolean eliminarTema(Long id) {
        try {
            temaRepository.deleteById(id);
            return true;  // Assuming deleteById does not throw an exception
        } catch (Exception e) {
            return false; // Handle the case where deletion is unsuccessful
        }
    }

    
}