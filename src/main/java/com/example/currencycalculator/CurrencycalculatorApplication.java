package com.example.currencycalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencycalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencycalculatorApplication.class, args);
	}

}
