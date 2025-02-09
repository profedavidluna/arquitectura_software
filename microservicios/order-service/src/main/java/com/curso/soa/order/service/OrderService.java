package com.curso.soa.order.service;

import com.curso.soa.order.entity.Pedido;
import com.curso.soa.order.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setEstado("Pendiente");
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
}