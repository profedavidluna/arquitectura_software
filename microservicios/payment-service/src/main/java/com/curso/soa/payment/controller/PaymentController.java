package com.curso.soa.payment.controller;

import com.curso.soa.payment.entity.Pago;
import com.curso.soa.payment.service.KafkaProducerService;
import com.curso.soa.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private  KafkaProducerService kafka;
    @PostMapping
    public Pago procesarPago(@RequestBody Pago pago) {


        kafka.sendPaymentMessage("Nuevo pago registrado: " + pago.getPedidoId() + " - " + pago.getMonto());

        return paymentService.procesarPago(pago);
    }

    @GetMapping
    public List<Pago> getPagos() {
        return paymentService.getPagos();
    }

}