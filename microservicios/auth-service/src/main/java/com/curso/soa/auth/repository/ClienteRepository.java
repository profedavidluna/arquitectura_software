package com.curso.soa.auth.repository;

import com.curso.soa.auth.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    Cliente findByEmailAndPassword(String email, String password);
}