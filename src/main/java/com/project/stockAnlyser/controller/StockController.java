package com.project.stockAnlyser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockAnlyser.client.StockClient;
import com.project.stockAnlyser.service.KafkaProducerService;

@RestController
public class StockController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private StockClient stockClient;

    @Value("${spring.kafka.topic.name}")
    private String topic;    

    @GetMapping("/stocks")
    public String getStocks() {

        // Implementation for fetching stocks
        System.out.println("Enter Stock Controller Service...");

        String result = stockClient.fetchStockData("IBM");
        
        System.out.println("result: "+ result);

        kafkaProducerService.sendMessage(topic, result);

        System.out.println("Exit Stock Controller Service...");
        
        return result;
    }
}
