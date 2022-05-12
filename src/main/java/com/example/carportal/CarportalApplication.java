package com.example.carportal;

import com.example.carportal.models.Car;
import com.example.carportal.repositories.CarDBHandler;
import com.example.carportal.repositories.IRepository;
import com.example.carportal.repositories.LeaseDBHandler;
import com.example.carportal.repositories.CarDBHandler;
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
        CarDBHandler handler = new CarDBHandler();
        handler.getOneEntity();*/
    }
}
