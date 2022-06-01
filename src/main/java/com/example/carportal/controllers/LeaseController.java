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

    private final LeaseService ls = new LeaseService(new LeaseRepository());
    private final JoinService js = new JoinService(new UserRepository(), new CarRepository());
    private final DamageService ds = new DamageService();
    private final SessionService ss = new SessionService();

    //@author: AC
    @GetMapping("/createlease")
    public String createLease(Model model, HttpSession session) {
        boolean hasAccess = ss.hasRegistrationRole(session);
        ArrayList<Customer> allCustomers = js.getListOfCustomers();
        ArrayList<Car> availableCars = js.getCars(1);
        model.addAttribute("allCustomers", allCustomers);
        model.addAttribute("availableCars", availableCars);
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return (hasAccess) ? "createlease" : "redirect:/accessdenied";
    }

    //@author: AC
    @PostMapping("/createlease")
    public String createLease(WebRequest request) {
        int carID = Integer.valueOf(request.getParameter("carID"));
        int customerID = Integer.valueOf(request.getParameter("customerID"));
        String pr = request.getParameter("price");
        String d1 = request.getParameter("startDate");
        String d2 = request.getParameter("endDate");
        boolean success = ls.validateLeaseForm(d1, d2, pr);
        if (success) {
            double price = Double.valueOf(pr);
            Date startDate = Date.valueOf(d1);
            Date endDate = Date.valueOf(d2);
            ls.createLeaseFromWebRequest(carID, customerID, price, startDate.toLocalDate(), endDate.toLocalDate(), true);
            js.changeCarStatus(carID);
        }
        return (success) ? "redirect:/createleasesuccess" : "redirect:/createlease";
    }

    //@author: AC
    @GetMapping("/createleasesuccess")
    public String leaseCreated(Model model, HttpSession session) {
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return "createleasesuccess";
    }

    //@author: GH
    @GetMapping("/chooselease")
    public String chooseLease(Model model, HttpSession session) {
        boolean hasAccess = ss.hasDamageRole(session);
        ArrayList<Lease> openLeases = ls.getAllOpenLeases();
        model.addAttribute("openLeases", openLeases);
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return (hasAccess) ? "chooselease" : "redirect:/accessdenied";
    }

    //@author: GH
    @PostMapping("/chooselease")
    public String choosingLease(WebRequest request, HttpSession session) {
        int leaseId = Integer.parseInt(request.getParameter("lease"));
        ss.addLeaseIDToSession(session, leaseId);
        return "redirect:/createdamagereport";
    }

    //@author: GH
    @GetMapping("/createdamagereport")
    public String getDamageData(Model model, HttpSession session) {
        int leaseID = ss.getLeaseIDFromSession(session);
        boolean hasAccess = ss.hasDamageRole(session);
        model.addAttribute("listOfDamages", ds.getSessionListOfDamages(session));
        model.addAttribute("leaseid", leaseID);
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return (hasAccess) ? "createdamagereport" : "redirect:/accessdenied";
    }

    //@author: GH
    @PostMapping("/createdamagereport")
    public String gettingDamageData(WebRequest request, HttpSession session) {
        String desc = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        ds.getSessionListOfDamages(session).add(ds.createDamageFromSession(0, desc, price));
        return "redirect:/createdamagereport";
    }
    //@author: GH
    @GetMapping("createdamagereportsuccess")
    public String gotDamageData(Model model, HttpSession session) {
        ArrayList<Damage> listOfDamages = ds.getSessionListOfDamages(session);
        int leaseID = ss.getLeaseIDFromSession(session);
        model.addAttribute("listOfDamages", listOfDamages);
        model.addAttribute("totalPrice", ds.getTotalDamage(session));
        model.addAttribute("leaseid", leaseID);
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Lokal", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);

        if (listOfDamages.size() != 0) {
            ls.createDamageReport(leaseID, listOfDamages);
        }
        ls.closeLease(leaseID);
        return "createdamagereportsuccess";
    }

    //@author: GH, EO
    @GetMapping("viewmonthlyincome")
    public String viewMonthlyIncome(HttpSession session, Model model) {
        boolean hasAccess = ss.hasBusinessRole(session);
        ArrayList<Lease> leases = ls.getAllOpenLeases();
        ArrayList<Statistic> stats = js.getListOfStatistics(leases);
        model.addAttribute("statistics", stats);
        model.addAttribute("numberOfLeasedCars", leases.size());
        model.addAttribute("totalPrice", ls.calculateMonthlyIncome(leases));
        model.addAttribute("username", ss.getSessionUser(session));
        String[] dbname = {"Local", "Heroku"};
        model.addAttribute("source", dbname[(int) session.getAttribute("source")]);
        return (hasAccess) ? "viewmonthlyincome" : "redirect:/accessdenied";
    }
}
