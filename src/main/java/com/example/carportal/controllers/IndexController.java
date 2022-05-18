package com.example.carportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("/")
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
    }


}
