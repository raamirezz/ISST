package com.isst.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.Registro;
import com.isst.demo.service.RegistroService;
import com.isst.demo.service.RegistroServiceImpl;

@CrossOrigin(origins = {"http://localhost:5501","http://localhost:8080"})
@RestController
@RequestMapping("api/registro/")
public class RegistroController {

    @Autowired
    private RegistroServiceImpl registroService;

    // Maneja las solicitudes GET a la ruta /registro
    @GetMapping("registros")
    public Registro mostrarFormularioRegistro() {

        Registro listaRegistro = registroService.consultarRegistro();
        System.out.println("Hola mundo");
        return listaRegistro; // Devuelve el nombre de la vista (registro.html en este caso)
    }


    // Maneja las solicitudes POST desde el formulario de registro
    @PostMapping("/registro")
    public String procesarRegistro(@RequestBody RegistroDTO registroDTO) {
        
        // Procesa los datos del formulario de registro (por ejemplo, guardar en la base de datos)
        // Aquí puedes agregar la lógica para procesar los datos del registro
        
        registroService.crearRegistroFormulario(registroDTO);
        // Redirige a la página de inicio después de procesar el registro
        return "redirect:/"; // Puedes redirigir a la página que desees
    }


}
