package com.curso.mvc.controller;

import com.curso.mvc.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import  com.curso.mvc.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/orders")
@Tag(name = "Pedidos", description = "Operaciones relacionadas con pedidos")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    @Operation(summary = "Listar pedidos", description = "Obtiene una lista de todos los pedidos.")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos obtenida correctamente.")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list";
    }

    @GetMapping("/new")
    @Operation(summary = "Mostrar formulario de pedido", description = "Muestra el formulario para crear un nuevo pedido.")
    @ApiResponse(responseCode = "200", description = "Formulario mostrado correctamente.")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orders/form";
    }

    @PostMapping
    @Operation(summary = "Crear pedido", description = "Crea un nuevo pedido.")
    @ApiResponse(responseCode = "302", description = "Pedido creado correctamente.")
    public String createOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
}