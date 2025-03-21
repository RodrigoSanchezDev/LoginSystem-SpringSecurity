package com.duoc.seguridadcalidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/home")
    public String userHome() {
        return "user/home";
    }

    @GetMapping("/programar_cita")
    public String programarCita() {
        return "user/programar_cita";
    }
}
