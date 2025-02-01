package com.curso.soa.payment.controller;

import com.curso.soa.payment.entity.Pago;
import com.curso.soa.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Pago procesarPago(@RequestBody Pago pago) {
        return paymentService.procesarPago(pago);
    }
}