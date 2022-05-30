package com.example.carportal.services;

import com.example.carportal.models.Damage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DamageService {


    public double getTotalDamage(HttpSession session) {
        double total = 0;
        ArrayList<Damage> listOfDamages = getSessionListOfDamages(session);
        for (Damage d : listOfDamages) {
            total += d.getPrice();
        }
        return total;
    }

    public ArrayList<Damage> getSessionListOfDamages(HttpSession session) {
        return (ArrayList<Damage>) session.getAttribute("listOfDamages");
    }

    public Damage createDamageFromSession(int i, String desc, Double price) {
        return new Damage(i, desc, price);
    }
}