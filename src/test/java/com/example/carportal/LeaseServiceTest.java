package com.example.carportal;

import com.example.carportal.repositories.ILeaseRepository;
import com.example.carportal.repositories.testRepositories.LeaseTestRepository;
import com.example.carportal.services.LeaseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaseServiceTest {

    @Test
    void calculateMonthlyEarnings(){
        //Arrange
        ILeaseRepository testLeaseRepository = new LeaseTestRepository();
        LeaseService serviceTest = new LeaseService(testLeaseRepository);
        double expected = 1502.0;
        //Act
        double result = serviceTest.calculateMonthlyEarnings();
        //Assert
        assertEquals(expected,result);
    }
}
