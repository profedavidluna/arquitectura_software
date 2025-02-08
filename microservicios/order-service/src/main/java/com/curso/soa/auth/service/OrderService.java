package com.curso.soa.auth.service;

import com.curso.soa.auth.entity.Pedido;
import com.curso.soa.auth.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setEstado("Pendiente");
        return pedidoRepository.save(pedido);
    }
}