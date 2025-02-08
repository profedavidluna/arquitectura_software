package com.curso.soa.auth.repository;

import com.curso.soa.auth.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}