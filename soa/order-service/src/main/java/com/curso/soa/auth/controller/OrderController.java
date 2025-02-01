package com.curso.soa.auth.controller;

import com.curso.soa.auth.entity.Pedido;
import com.curso.soa.auth.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return orderService.crearPedido(pedido);
    }
}
