package com.example.flighttransactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlightTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightTransactionalApplication.class, args);
    }

}
