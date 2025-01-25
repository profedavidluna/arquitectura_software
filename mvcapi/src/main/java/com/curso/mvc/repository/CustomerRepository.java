package com.curso.mvc.repository;


import com.curso.mvc.entities.Customer;
import com.curso.mvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}