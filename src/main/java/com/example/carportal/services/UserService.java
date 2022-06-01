package com.example.carportal.services;

import com.example.carportal.models.User;
import com.example.carportal.repositories.IUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {

    private final IUserRepository ur;

    public UserService(IUserRepository injectedUserRepository) {
        ur = injectedUserRepository;
    }

    //@author: AC
    public void addUserToSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", ur.getUser("guest"));
    }

    //@author: EO
    public User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute("sessionUser");
    }

    //@author: MS
    public boolean validateCredentials(String username, String password) {
        return ur.validateCredentials(username, password);
    }

    //@author: GH
    public User getUser(String username) {
        return ur.getUser(username);
    }
}
