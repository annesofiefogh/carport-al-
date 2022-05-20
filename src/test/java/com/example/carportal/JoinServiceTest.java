package com.example.carportal;

import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.ICarRepository;
import com.example.carportal.repositories.IUserRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.repositories.testRepositories.CarTestRepository;
import com.example.carportal.repositories.testRepositories.UserTestRepository;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class JoinServiceTest {

    @Test
    void getListOfCustomers() {
        //Arrange
        IUserRepository testUserRepository = new UserTestRepository();
        ICarRepository testCarRepository = new CarTestRepository();
        JoinService serviceTest = new JoinService(testUserRepository, testCarRepository);
        boolean expected = true;
        //Act
        boolean result = serviceTest.getListOfCustomers().size() == 3;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getListOfAvailableCars() {

        //Arrange
        IUserRepository testUserRepository = new UserTestRepository();
        ICarRepository testCarRepository = new CarTestRepository();
        JoinService serviceTest = new JoinService(testUserRepository, testCarRepository);
        boolean expected = true;
        //Act
        boolean result = serviceTest.getListOfAvailableCars().size() == 3;
        //Assert
        assertEquals(expected,result);
    }
}

