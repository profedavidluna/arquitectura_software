package com.curso.soa.catalog.controller;

import com.curso.soa.catalog.entity.Product;
import com.curso.soa.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/productos")
    public List<Product> obtenerProductos() {
        return catalogService.obtenerProductos();
    }
}