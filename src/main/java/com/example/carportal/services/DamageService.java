package com.example.carportal.services;

import com.example.carportal.models.Damage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DamageService
{
    public void addListOfDamagesToSession(HttpServletRequest request) {
        ArrayList<Damage> listOfDamages = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setAttribute("listOfDamages", listOfDamages);
    }

    public double getTotalDamage(HttpSession session) {
        double total = 0;
        ArrayList<Damage> listOfDamages = getSessionListOFDamages(session);
        for (Damage d : listOfDamages) {
            total += d.getPrice();
        }
        return total;
    }

    public ArrayList<Damage> getSessionListOFDamages(HttpSession session) {
        return (ArrayList<Damage>) session.getAttribute("listOfDamages");
    }
}