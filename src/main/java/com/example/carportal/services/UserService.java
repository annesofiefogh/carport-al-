package com.example.carportal.services;

import com.example.carportal.models.User;
import com.example.carportal.repositories.IUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {

    private IUserRepository ur;

    public UserService(IUserRepository injectedUserRepository){
        ur = injectedUserRepository;
    }

    public UserService(){}

    public void addUserToSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", ur.getUser(2));
    }

    public User getUserFromSession(HttpSession session){
        return (User) session.getAttribute("sessionUser");
    }

    public User getUser(String username) {
        return ur.getUser(username);
    }
}
