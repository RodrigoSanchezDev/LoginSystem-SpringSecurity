package com.duoc.seguridadcalidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(
        @RequestParam(name="name", required=false, defaultValue="Seguridad y Calidad en el Desarrollo") 
        String name, 
        Model model
    ) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/")
    public String root(
        @RequestParam(name="name", required=false, defaultValue="Seguridad y Calidad en el Desarrollo") 
        String name, 
        Model model
    ) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Rutas de admin y user se quitan de este controlador

    @GetMapping("/guest/welcome")
    public String guestWelcome() {
        return "guest/welcome";
    }
}
