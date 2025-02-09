package com.curso.soa.auth.service;

import com.curso.soa.auth.entity.Cliente;
import com.curso.soa.auth.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private  KafkaProducerService kafka;
    public Cliente registrarCliente(Cliente cliente) {
        kafka.sendAuthMessage("Nuevo usuario registrado: " + cliente.getNombre());
        return clienteRepository.save(cliente);
    }

    public Cliente autenticarCliente(String email, String password) {
        return clienteRepository.findByEmailAndPassword(email, password);
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

}