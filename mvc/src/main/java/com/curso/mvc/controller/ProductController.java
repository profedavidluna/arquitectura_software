package com.curso.mvc.controller;


import com.curso.mvc.entities.Product;
import com.curso.mvc.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@Tag(name = "Productos", description = "Operaciones relacionadas con productos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene una lista de todos los productos.")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente.")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/new")
    @Operation(summary = "Mostrar formulario de producto", description = "Muestra el formulario para crear un nuevo producto.")
    @ApiResponse(responseCode = "200", description = "Formulario mostrado correctamente.")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    @PostMapping
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto.")
    @ApiResponse(responseCode = "302", description = "Producto creado correctamente.")
    public String createProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}