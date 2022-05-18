package com.example.carportal.services;

import com.example.carportal.models.Damage;
import com.example.carportal.models.User;
import com.example.carportal.repositories.IUserRepository;
import com.example.carportal.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class UserService {

    private IUserRepository ur;

    public UserService(IUserRepository injectedUserRepository){
        ur = injectedUserRepository;
    }

    public UserService(){}

    public void addUserToSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", ur.getOneUser(2));
    }

    public User getUserFromSession(HttpSession session){
        return (User) session.getAttribute("sessionUser");
    }

    public int getUser(String username, String password) {
        return ur.getUser(username, password);
    }
}
