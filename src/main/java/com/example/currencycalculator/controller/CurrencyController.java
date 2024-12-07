package com.example.currencycalculator.controller;

import com.example.currencycalculator.model.Currency;
import com.example.currencycalculator.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public Map<String, Currency> getRates() {
        return currencyService.getCurrencyRates();
    }

    @GetMapping("/convert")
    public double convert(@RequestParam double amount,
                          @RequestParam String from,
                          @RequestParam String to) {
        Map<String, Currency> rates = currencyService.getCurrencyRates();

        // Проверка на существование валют
        if (!rates.containsKey(from) && !from.equals("RUB")) {
            throw new IllegalArgumentException("Unsupported currency code: " + from);
        }
        if (!rates.containsKey(to) && !to.equals("RUB")) {
            throw new IllegalArgumentException("Unsupported currency code: " + to);
        }

        // Обработка конвертации из RUB в RUB
        if (from.equals("RUB") && to.equals("RUB")) {
            return amount; // Если конвертация из RUB в RUB, просто возвращаем ту же сумму
        }

        double fromRate;
        double toRate;

        if (from.equals("RUB")) {
            // Конвертация из RUB в другую валюту
            toRate = rates.get(to).getValue() / rates.get(to).getNominal(); // Курс целевой валюты
            return round(amount / toRate); // Конвертация с округлением
        } else if (to.equals("RUB")) {
            // Конвертация из другой валюты в RUB
            fromRate = rates.get(from).getValue() / rates.get(from).getNominal(); // Курс исходной валюты
            return round(amount * fromRate); // Конвертация с округлением
        } else {
            // Конвертация между двумя не рублевыми валютами
            fromRate = rates.get(from).getValue() / rates.get(from).getNominal(); // Курс исходной валюты
            toRate = rates.get(to).getValue() / rates.get(to).getNominal(); // Курс целевой валюты
            return round(amount * (toRate / fromRate)); // Прямой расчет между валютами с округлением
        }
    }

    // Метод для округления до двух знаков после запятой
    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}