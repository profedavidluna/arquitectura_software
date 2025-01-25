package com.curso.mvc.repository;


import com.curso.mvc.entities.Customer;
import com.curso.mvc.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}