package com.isst.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<TemaDTO> obtenerTodosLosTemas() {
        List<Tema> temas = new ArrayList<>();
temaRepository.findAll().forEach(temas::add);

        return temas.stream()
                    .map(tema -> modelMapper.map(tema, TemaDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public TemaDTO obtenerTemaPorId(Long id) {
        Tema tema = temaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        return modelMapper.map(tema, TemaDTO.class);
    }

    @Override
    public TemaDTO crearTema(TemaDTO temaDTO) {
        // Convertir DTO a entidad
        Tema tema = modelMapper.map(temaDTO, Tema.class);
        // Guardar entidad
        tema = temaRepository.save(tema);
        // Verificar si el tema es importante y enviar correo
        if (tema.getIsImportant()) {
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

    
}