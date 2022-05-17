package com.example.carportal.controllers;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.util.ArrayList;

@Controller
public class LeaseController {

    private LeaseService ls = new LeaseService();
    private JoinService js = new JoinService();

    @GetMapping("/createlease")
    public String createLease(Model model){
        ArrayList<Customer> allCustomers = js.getListOfCustomers();
        ArrayList<Car> availableCars = js.getListOfAvailableCars();
        model.addAttribute("allCustomers", allCustomers);
        model.addAttribute("availableCars", availableCars);
        return "createlease";
    }

    @PostMapping("/createlease")
    public String createLease(WebRequest request){
        double price = Double.parseDouble(request.getParameter("price"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Lease lease = new Lease()
        return "redirect:/createleasesuccess";
    }

    @GetMapping("/createleasesuccess")
    public String leaseCreated(){
        return "createleasesuccess";
    }

}
