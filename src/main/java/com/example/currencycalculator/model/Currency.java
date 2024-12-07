package com.example.currencycalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    @JsonProperty("ID")
    private String id; // Поле для ID валюты

    @JsonProperty("NumCode")
    private String numCode; // Поле для числового кода

    @JsonProperty("CharCode")
    private String charCode; // Поле для символа валюты

    @JsonProperty("Nominal")
    private int nominal; // Поле для номинала

    @JsonProperty("Name")
    private String name; // Поле для названия валюты

    @JsonProperty("Value")
    private double value; // Поле для курса валюты

    @JsonProperty("Previous")
    private double previous; // Поле для предыдущего курса

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value; // Геттер для курса валюты
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPrevious() {
        return previous; // Геттер для предыдущего курса
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }
}