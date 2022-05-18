package com.example.carportal.controllers;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.LeaseRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class LeaseController {

    private LeaseService ls = new LeaseService(new LeaseRepository());
    private JoinService js = new JoinService(new UserRepository(),new CarRepository());

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
        js.changeCarStatus(carID);
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
    public String createDamageReport(WebRequest dataFromForm, HttpServletRequest request){
        int leaseID = Integer.valueOf(dataFromForm.getParameter("leaseID"));
        String description = dataFromForm.getParameter("description");
        double price = Double.parseDouble(dataFromForm.getParameter("price"));
        HttpSession session = request.getSession();

        Damage damage = new Damage(description,price);
        ls.getAllDamagesOnLease(leaseID, damage);
        return "redirect:/createdamagereportsuccess";
    }

}
