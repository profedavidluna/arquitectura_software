package com.curso.soa.payment.repository;

import com.curso.soa.payment.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}