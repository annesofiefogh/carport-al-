package com.example.carportal.controllers;

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

    private final UserService us = new UserService(new UserRepository());

    @GetMapping("/index")
    public String login(Model model, HttpSession session, HttpServletRequest request) {
        // logout is login as guest
        us.addUserToSession(request);
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        model.addAttribute("username", us.getUserFromSession(session));
        us.getUserFromSession(session);
        return "index";
    }

    @PostMapping("/index")
    public String login(WebRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validated = us.validateCredentials(username,password);
        if (validated){
            session.setAttribute("sessionUser", us.getUser(username));
        } else {
            session.setAttribute("sessionUser", us.getUser("guest"));
        }
        return (validated) ? "redirect:/mainpage" : "redirect:/index";
    }

    @GetMapping("/accessdenied")
    public String accessDenied() {
        return "noaccess";
    }
}
