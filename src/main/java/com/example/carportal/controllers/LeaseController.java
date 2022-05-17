package com.example.carportal.controllers;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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
        int carID = Integer.valueOf(request.getParameter("carID"));
        int customerID = Integer.valueOf(request.getParameter("customerID"));
        double price = Double.parseDouble(request.getParameter("price"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Lease lease = new Lease(carID, customerID, price, startDate.toLocalDate(), endDate.toLocalDate(), true);
        ls.createLease(lease);
        return "redirect:/createleasesuccess";
    }

    @GetMapping("/createleasesuccess")
    public String leaseCreated(){
        return "createleasesuccess";
    }

    @GetMapping("/createdamagereport")
    public String closeLease(Model model){
        model.addAttribute("openLeases", ls.getAllOpenLeases());
        return "createdamagereport";
    }

    @PostMapping("/createdamagereport")
    public String createDamageReport(WebRequest request){
        int leaseID = Integer.valueOf(request.getParameter("leaseID"));
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        Damage damage = new Damage()
    }

}
