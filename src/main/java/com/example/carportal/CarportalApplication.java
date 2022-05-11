package com.example.carportal;

import com.example.carportal.models.Car;
import com.example.carportal.repositories.CarDBHandler;
import com.example.carportal.repositories.IRepository;
import com.example.carportal.repositories.LeaseDBHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CarportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarportalApplication.class, args);

    }
}
