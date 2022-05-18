package com.example.carportal.controllers;

import com.example.carportal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService us;

    @GetMapping()
    public String login(){
        return "login";
    }



}
