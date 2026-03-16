package com.project.stockAnlyser.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.api.base-url}")
    private String BaseURL;

    @Value("${spring.api.key}")
    private String apiKey;

    public String fetchStockData(String value) {
        // Simulate fetching stock data from an external API

        try{

            String apiURL = BaseURL +"?function=TIME_SERIES_DAILY"
                + "&symbol=" + value
                + "&apikey=" + apiKey;      

            System.out.println("API URL: " + apiURL);

            String result= restTemplate.getForObject(apiURL, String.class);
            return result;

        }catch(Exception e){
            System.out.println("Error fetching stock data: " + e.getMessage());
            return e.getMessage();
        }
        
    }
    
}
