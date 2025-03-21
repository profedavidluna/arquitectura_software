package com.curso.mvc.dto;

import com.curso.mvc.entities.Customer;
import lombok.Data;

@Data
public class CustomerDTO {
    private String nombre;
    private String correo;

    public static Customer from(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getNombre());
        customer.setEmail(dto.getCorreo());
        return customer;
    }
}
