package com.example.carportal.controllers;

import com.example.carportal.models.User;
import com.example.carportal.repositories.IUserRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService us = new UserService(new UserRepository());

    @GetMapping("/")
    public String landPage(HttpServletRequest request){
        us.addUserToSession(request);
        return "index";
    }

    @GetMapping("/index")
    public String login(Model model, HttpSession session){
        model.addAttribute("username", us.getUserFromSession(session));
        System.out.println(us.getUserFromSession(session));
        return "index";
    }

    @PostMapping("/index")
    public String login(WebRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("sessionUser", us.getUser(username));
        return "redirect:/mainpage";
    }


}
