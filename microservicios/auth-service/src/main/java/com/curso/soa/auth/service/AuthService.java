package com.curso.soa.auth.service;

import com.curso.soa.auth.entity.Cliente;
import com.curso.soa.auth.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente autenticarCliente(String email, String password) {
        return clienteRepository.findByEmailAndPassword(email, password);
    }
}