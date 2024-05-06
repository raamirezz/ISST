package com.isst.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isst.demo.entity.Registro;
import com.isst.demo.service.RegistroService;

@Controller
public class PerfilController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/perfil")
    public String showProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // Obtén el nombre de usuario del usuario autenticado

        // Supongamos que tienes un método para buscar el registro por nombre de usuario
        Registro registro = registroService.findByUsername(username);

        model.addAttribute("registro", registro);
        return "perfil"; // nombre del archivo HTML de Thymeleaf sin la extensión .html
    }
}



