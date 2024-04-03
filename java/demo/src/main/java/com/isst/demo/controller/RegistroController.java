package com.isst.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isst.demo.service.RegistroService;
import com.isst.demo.service.RegistroServiceImpl;

@RestController
@RequestMapping("api/registro/")
public class RegistroController {

    @Autowired
    private RegistroServiceImpl registroService;

    // Maneja las solicitudes GET a la ruta /registro
    @GetMapping("registros")
    public String mostrarFormularioRegistro() {
        System.out.println("Hola mundo");
        return "Pedrito"; // Devuelve el nombre de la vista (registro.html en este caso)
    }


    // Maneja las solicitudes POST desde el formulario de registro
    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam("nombre") String nombre, @RequestParam("email") String email) {
        // Procesa los datos del formulario de registro (por ejemplo, guardar en la base de datos)
        // Aquí puedes agregar la lógica para procesar los datos del registro
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        registroService.crearRegistroFormulario(null);
        // Redirige a la página de inicio después de procesar el registro
        return "redirect:/"; // Puedes redirigir a la página que desees
    }
}
