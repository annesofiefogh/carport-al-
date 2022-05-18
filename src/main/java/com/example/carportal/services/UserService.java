package com.example.carportal.services;

import com.example.carportal.repositories.IUserRepository;
import com.example.carportal.repositories.UserRepository;

public class UserService {

    private IUserRepository ur;

    public UserService(IUserRepository injectedUserRepository){
        ur = injectedUserRepository;
    }

}
