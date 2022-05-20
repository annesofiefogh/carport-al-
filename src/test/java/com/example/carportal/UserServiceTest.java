package com.example.carportal;

import com.example.carportal.repositories.IUserRepository;
import com.example.carportal.repositories.testRepositories.UserTestRepository;
import com.example.carportal.services.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserServiceTest {


    @Test
    void validateCredentials() {
        //Arrange
        IUserRepository testUserRepository = new UserTestRepository();
        UserService serviceTest = new UserService(testUserRepository);
        boolean expected = true;
        //Act
        boolean result = serviceTest.validateCredentials("Torb123", "torbWord");
        //Assert
        assertEquals(expected, result);

    }
}
