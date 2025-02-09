package com.curso.soa.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    // Inyección a través del constructor
    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAuthMessage(String message) {
        kafkaTemplate.send("auth-topic", message);
    }

    public void sendPaymentMessage(String message) {
        kafkaTemplate.send("payment-topic", message);
    }
}