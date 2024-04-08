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

import com.isst.demo.dto.ContactoDTO;
import com.isst.demo.entity.Contacto;
import com.isst.demo.service.ContactoService;
import com.isst.demo.service.ContactoServiceImpl;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/contacto/")
public class ContactoController {

    @Autowired
    private ContactoServiceImpl contactoService;

    // Maneja las solicitudes GET a la ruta /contacto
    @GetMapping("contactos")
    public Contacto mostrarFormularioContacto() {

        Contacto listaContacto = contactoService.consultarContacto();
        System.out.println("Hola mundo");
        return listaContacto; // Devuelve el nombre de la vista (contacto.html en este caso)
    }


    // Maneja las solicitudes POST desde el formulario de contacto
    @PostMapping("/contacto")
    public String procesarContacto(@RequestBody ContactoDTO contactoDTO) {
        
        // Procesa los datos del formulario de contacto (por ejemplo, guardar en la base de datos)
        // Aquí puedes agregar la lógica para procesar los datos del contacto
        
        contactoService.crearContactoFormulario(contactoDTO);
        // Redirige a la página de inicio después de procesar el contacto
        return "redirect:/"; // Puedes redirigir a la página que desees
    }


}
