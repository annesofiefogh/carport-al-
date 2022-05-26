package com.example.carportal.controllers;

import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {

    private JoinService js = new JoinService(new UserRepository(),new CarRepository());

    @GetMapping("/viewstock")
    public String  viewstock(Model model)
    {
        model.addAttribute("leased",js.getCars(0));
        model.addAttribute("available",js.getCars(1));
        return "viewstock";
    }
}
