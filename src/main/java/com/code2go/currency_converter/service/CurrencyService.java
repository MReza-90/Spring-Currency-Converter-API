package com.code2go.currency_converter.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {


    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY//latest/";


    // Method to get list of currencies for a given base currency
    public Map<String, Object> getCurrencies(String currency) {
        // Make an HTTP GET request to the third-party API
        ResponseEntity<Map> response = restTemplate.getForEntity(apiUrl + currency, Map.class);

        // Check if the response is successful
        if (response.getStatusCode().is2xxSuccessful()) {
            // Return the response body, which is the list of currencies
            return response.getBody();
        }
        throw new RuntimeException("Failed to retrieve currencies");
    }

    public double getExchangeRate(String from, String to) {
        String url = apiUrl + from;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Map<String, Double> rates = (Map<String, Double>) response.getBody().get("rates");
            return rates.get(to);
        }
        throw new RuntimeException("Unable to fetch exchange rate");
    }

}
