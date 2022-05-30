package com.example.carportal.controllers;

import com.example.carportal.models.*;
import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.LeaseRepository;
import com.example.carportal.repositories.UserRepository;
import com.example.carportal.services.DamageService;
import com.example.carportal.services.JoinService;
import com.example.carportal.services.LeaseService;
import com.example.carportal.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

@Controller
public class LeaseController {

    private LeaseService ls = new LeaseService(new LeaseRepository());
    private JoinService js = new JoinService(new UserRepository(),new CarRepository());
    private DamageService ds = new DamageService();
    private SessionService ss = new SessionService();

    @GetMapping("/createlease")
    public String createLease(Model model, HttpSession session){
        boolean hasAccess = ss.hasRegistrationRole(session);
        ArrayList<Customer> allCustomers = js.getListOfCustomers();
        ArrayList<Car> availableCars = js.getCars(1);
        model.addAttribute("allCustomers", allCustomers);
        model.addAttribute("availableCars", availableCars);
        return (hasAccess) ? "createlease" : "redirect:/accessdenied";
    }

    @PostMapping("/createlease")
    public String createLease(WebRequest request){
        int carID = Integer.valueOf(request.getParameter("carID"));
        int customerID = Integer.valueOf(request.getParameter("customerID"));
        double price = Double.parseDouble(request.getParameter("price"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        ls.createLeaseFromWebRequest(carID, customerID, price, startDate.toLocalDate(), endDate.toLocalDate(), true);
        js.changeCarStatus(carID);
        return "redirect:/createleasesuccess";
    }

    @GetMapping("/createleasesuccess")
    public String leaseCreated(){
        return "createleasesuccess";

    }
    @GetMapping("/chooselease")
    public String chooseLease(Model model, HttpSession session)
    {
        boolean hasAccess = ss.hasDamageRole(session);
        ArrayList<Lease> openLeases = ls.getAllOpenLeases();
        model.addAttribute("openLeases", openLeases);
        return (hasAccess) ? "chooselease" : "redirect:/accessdenied";
    }

    @PostMapping("/chooselease")
    public String choosingLease(WebRequest request, HttpSession session)    {
        int leaseId = Integer.parseInt(request.getParameter("lease"));
        ss.addLeaseIDToSession(session, leaseId);
        return "redirect:/createdamagereport";
    }

    @GetMapping("/createdamagereport")
    public String getDamageData(Model model, HttpSession session)
    {
        int leaseID = ss.getLeaseIDFromSession(session);
        boolean hasAccess = ss.hasDamageRole(session);
        model.addAttribute("listOfDamages", ds.getSessionListOfDamages(session));
        model.addAttribute("leaseid", leaseID);
        return (hasAccess) ? "createdamagereport" : "redirect:/accessdenied";
    }

    @PostMapping("/createdamagereport")
    public String gettingDamageData(WebRequest request, HttpSession session)
    {
        String desc = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        ds.getSessionListOfDamages(session).add(ds.createDamageFromSession(0, desc, price));
        return "redirect:/createdamagereport";
    }

    @GetMapping("createdamagereportsuccess")
    public String gotDamageData(Model model, HttpSession session) {
        ArrayList<Damage> listOfDamages = ds.getSessionListOfDamages(session);
        int leaseID = ss.getLeaseIDFromSession(session);
        model.addAttribute("listOfDamages", listOfDamages);
        model.addAttribute("totalPrice", ds.getTotalDamage(session));
        model.addAttribute("leaseid", leaseID);
        if (listOfDamages.size() != 0) { //Todo, Graham skal lige fortælle Mikkel præcis hvordan det her loop fungerer
            ls.createDamageReport(leaseID, listOfDamages);
        }
        return "createdamagereportsuccess";
    }

    @GetMapping("viewmonthlyincome")
    public String viewMonthlyIncome(HttpSession session, Model model)
    {
        boolean hasAccess = ss.hasBusinessRole(session);
        ArrayList<Lease> leases = ls.getAllOpenLeases();
        ArrayList<Statistic> stats = js.getListOfStatistics(leases);
        model.addAttribute("statistics", stats);
        model.addAttribute("numberOfLeasedCars" , leases.size());
        model.addAttribute("totalPrice", ls.calculateMonthlyIncome(leases));
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Local", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return (hasAccess) ? "viewmonthlyincome" : "redirect:/accessdenied";
    }
}
