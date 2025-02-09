package com.curso.soa.analitica.service;

import com.curso.soa.analitica.entity.Data;
import com.curso.soa.analitica.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @Autowired
    private DataRepository dataRepository;

    @KafkaListener(topics = "auth-topic", groupId = "analytica-group")
    public void listenAuthTopic(String message) {
        System.out.println("Received Message in group 'analytica-group': " + message);
        Data data = new Data();
        data.setData(message);
        data.setService("auth-service");
        dataRepository.save(data);
    }

    @KafkaListener(topics = "payment-topic", groupId = "analytica-group")
    public void listenPaymentTopic(String message) {
        System.out.println("Received Message in group 'analytica-group': " + message);
        Data data = new Data();
        data.setData(message);
        data.setService("payment-service");
        dataRepository.save(data);
    }
}