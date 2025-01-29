package com.curso.soa.catalog.controller;

import com.curso.soa.catalog.entity.Product;
import com.curso.soa.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CatalogService authService;

    @PostMapping("/registro")
    public Product registrarCliente(@RequestBody Product cliente) {
        return authService.registrarCliente(cliente);
    }

    @PostMapping("/login")
    public Product autenticarCliente(@RequestParam String email, @RequestParam String password) {
        return authService.autenticarCliente(email, password);
    }
}