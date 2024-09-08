package com.code2go.currency_converter.controller;

import com.code2go.currency_converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/convert")
    public ResponseEntity<String> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        double rate = currencyService.getExchangeRate(from, to);
        double convertedAmount = amount * rate;

        return ResponseEntity.ok("Converted Amount: " + convertedAmount);
    }


     // Endpoint to return list of currencies
    @GetMapping("/{currency}")
    public ResponseEntity<Map<String, Object>> currencyList(@PathVariable String currency) {
        // Call the service to get the list of currencies
        Map<String, Object> response = currencyService.getCurrencies(currency);

        // Return the JSON response
        return ResponseEntity.ok(response);
    }

}
