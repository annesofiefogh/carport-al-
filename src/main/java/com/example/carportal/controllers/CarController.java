package com.example.carportal.controllers;

import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class CarController {

    private JoinService js = new JoinService(new UserRepository(),new CarRepository());
    private SessionService ss = new SessionService();

    @GetMapping("/viewstock")
    public String viewstock(Model model, HttpSession session)
    {
        model.addAttribute("leased",js.getCars(0));
        model.addAttribute("available",js.getCars(1));
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Local", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return "viewstock";
    }
}
