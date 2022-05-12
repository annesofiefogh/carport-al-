package com.example.carportal;

import com.example.carportal.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarportalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CarportalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hey allesammen");
        CarRepository handler = new CarRepository();
        handler.getOneEntity(1);
    }
}
