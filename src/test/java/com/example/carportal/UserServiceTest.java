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
        boolean expected2 = false;
        //Act
        boolean result = serviceTest.validateCredentials("Torb123", "torbWord");
        boolean result2 = serviceTest.validateCredentials("Torb123", "wrongpassword");
        boolean result3 = serviceTest.validateCredentials("wrongusername", "torbWord");
        boolean result4 = serviceTest.validateCredentials("wrongusername", "wrongpassword");
        //Assert
        assertEquals(expected, result);
        assertEquals(expected2, result2);
        assertEquals(expected2, result3);
        assertEquals(expected2, result4);

    }
}
