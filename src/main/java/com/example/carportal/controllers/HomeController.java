package com.example.carportal.controllers;

import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.DamageService;
import com.example.carportal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController
{

    private DamageService ds = new DamageService();
    private UserService us = new UserService(new UserRepository());

    @GetMapping("/mainpage")
    public String index(HttpSession session, HttpServletRequest request, Model model){
        ds.addListOfDamagesToSession(request);
        model.addAttribute("sessionUser", us.getUserFromSession(session));
        return "mainpage";
    }

    /*@GetMapping("/")
    public String startPage(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/loggedin")
    public String loggedIn(){
        return "loggedin";
    }

    @PostMapping("/index")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        return "redirect:/loggedin";
    }*/
}
