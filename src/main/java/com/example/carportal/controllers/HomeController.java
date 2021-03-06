package com.example.carportal.controllers;

import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.SessionService;
import com.example.carportal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService us = new UserService(new UserRepository());
    private final SessionService ss = new SessionService();

    //@author: GH
    @GetMapping("/")
    public String landPage() {
        return "database";
    }

    //@author: GH
    @GetMapping("/selectDb")
    public String chooseDb() {
        return "database";
    }

    //@author: GH
    @PostMapping("/selectDb")
    public String chosenDb(WebRequest webrequest, HttpSession session, HttpServletRequest request) {
        int dbSource = Integer.parseInt(webrequest.getParameter("source"));
        session.setAttribute("source", dbSource);
        ss.setDbSource(dbSource);
        us.addUserToSession(request);
        return "redirect:/index";
    }

    //@author: GH
    @GetMapping("/mainpage")
    public String index(HttpSession session, HttpServletRequest request, Model model) {
        ss.addListOfDamagesToSession(request);
        model.addAttribute("sessionUser", us.getUserFromSession(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return "mainpage";
    }
}
