package com.example.carportal;

import com.example.carportal.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CarportalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CarportalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Hey allesammen");
        CarDBHandler handler = new CarRepository();
        handler.getOneEntity();*/
    }
}
