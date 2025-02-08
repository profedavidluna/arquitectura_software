package com.curso.soa.auth.controller;

import com.curso.soa.auth.entity.Cliente;
import com.curso.soa.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registro")
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return authService.registrarCliente(cliente);
    }

    @PostMapping("/login")
    public Cliente autenticarCliente(@RequestParam String email, @RequestParam String password) {
        return authService.autenticarCliente(email, password);
    }
}