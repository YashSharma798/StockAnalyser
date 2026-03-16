package com.project.stockAnlyser.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Value("${spring.kafka.topic.name}")
    private String topic;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "stock-analyser-group")
    public void consumeMessage(String message){
        System.out.println("Message consumed from Kafka topic: " + message);
    }
}
