package com.example.carportal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class IndexController {

    @GetMapping("/")
    public String startPage(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/LoggedIn")
    public String loggedIn(){
        return "LoggedIn";
    }

    @PostMapping("/index")
    public String login(){
        return "redirect:/LoggedIn";
    }

}
