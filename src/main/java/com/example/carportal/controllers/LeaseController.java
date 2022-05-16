package com.example.carportal.controllers;

import com.example.carportal.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;

@Controller
public class LeaseController {

    private LeaseService ls;

    @GetMapping("/createlease")
    public String createLease(){
        return "createlease";
    }

    @PostMapping("/createlease")
    public String createLease(WebRequest request){

        double price = Double.parseDouble(request.getParameter("price"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        return "redirect:/createleasesuccess";
    }

}
