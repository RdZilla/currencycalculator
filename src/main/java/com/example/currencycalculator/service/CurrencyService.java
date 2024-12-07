package com.example.currencycalculator.service;

import com.example.currencycalculator.model.Currency;
import com.example.currencycalculator.model.CurrencyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    private final String API_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    @Cacheable(value = "currencyRates")
    public Map<String, Currency> getCurrencyRates() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        CurrencyResponse currencyResponse;

        try {
            response = response.replaceAll("^[^\\{]*", ""); // Удаляем лишние символы перед JSON
            currencyResponse = objectMapper.readValue(response, CurrencyResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>(); // Возвращаем пустую карту в случае ошибки
        }

        return currencyResponse.getValute();
    }
}