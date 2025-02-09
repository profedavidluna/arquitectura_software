package com.curso.soa.catalog.service;

import com.curso.soa.catalog.entity.Product;
import com.curso.soa.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogService {

    @Autowired
    private ProductRepository productoRepository;

    public List<Product> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Product addProducto(Product p) {
        return productoRepository.save(p);
    }
}