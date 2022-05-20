package com.example.carportal.controllers;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.LeaseRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.DamageService;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class LeaseController {

    private LeaseService ls = new LeaseService(new LeaseRepository());
    private JoinService js = new JoinService(new UserRepository(),new CarRepository());
    private DamageService ds = new DamageService();

    @GetMapping("/createlease")
    public String createLease(Model model){
        ArrayList<Customer> allCustomers = js.getListOfCustomers();
        ArrayList<Car> availableCars = js.getCars(1);
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
    public String getdata(Model model, HttpSession session)
    {
        ArrayList<Integer> openLeaseIds = new ArrayList<>(Arrays.asList(22, 37, 39));
        model.addAttribute("listOfDamages", ds.getSessionListOFDamages(session));
        model.addAttribute("openLeases", openLeaseIds);
        return "createdamagereport";
    }

    @PostMapping("/createdamagereport")
    public String gettingdata(WebRequest request, HttpSession session)
    {
        int leaseId = Integer.parseInt(request.getParameter("leaseId"));
        String desc = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        ds.getSessionListOFDamages(session).add(new Damage(leaseId, desc, price));
        return "redirect:/createdamagereport";
    }

    @GetMapping("createdamagereportsuccess")
    public String gotdata(Model model, HttpSession session)
    {
        model.addAttribute("listOfDamages", ds.getSessionListOFDamages(session));
        model.addAttribute("totalPrice", ds.getTotalDamage(session));
        System.out.println(ds.getTotalDamage(session));
        return "createdamagereportsuccess";
    }

    @GetMapping("viewmonthlyincome")
    public String viewmonthlyincome(Model model)
    {
        model.addAttribute("listOfUnavailableCars", js.getCars(0));
        model.addAttribute("totalPrice", ls.calculateMonthlyEarnings());
        model.addAttribute("listOfOpenLeases", ls.getAllOpenLeases());

        return "viewmonthlyincome";
    }

}
