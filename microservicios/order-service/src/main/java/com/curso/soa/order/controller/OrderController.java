package com.curso.soa.order.controller;

import com.curso.soa.order.entity.Pedido;
import com.curso.soa.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return orderService.crearPedido(pedido);
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return orderService.getPedidos();
    }
}
