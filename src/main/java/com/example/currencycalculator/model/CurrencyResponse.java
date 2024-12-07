package com.example.currencycalculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true) // Игнорировать неизвестные поля
public class CurrencyResponse {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Valute")
    private Map<String, Currency> valute;

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    public Map<String, Currency> getValute() {
        return valute;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValute(Map<String, Currency> valute) {
        this.valute = valute;
    }
}