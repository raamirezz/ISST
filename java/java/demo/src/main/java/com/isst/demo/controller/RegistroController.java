package com.isst.demo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.dto.RegistroDTO;
import com.isst.demo.entity.Registro;
import com.isst.demo.service.RegistroService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/registro/")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    // Maneja las solicitudes GET a la ruta /registro
    @GetMapping("registros")
    public Registro mostrarFormularioRegistro() {

        Registro listaRegistro = registroService.consultarRegistro();
        System.out.println("Hola mundo");
        return listaRegistro; // Devuelve el nombre de la vista (registro.html en este caso)
    }


    // Maneja las solicitudes POST desde el formulario de registro
    @PostMapping("/registro")
public ResponseEntity<RegistroDTO> procesarRegistro(@RequestBody RegistroDTO registroDTO) {
    try {
        registroService.crearRegistroFormulario(registroDTO);
        return ResponseEntity.ok(registroDTO);
    } catch (Exception e) {
        // Loguear el error para depuración
        Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, "Error al procesar registro", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}




}