package com.example.carportal.services;

import com.example.carportal.models.Damage;
import com.example.carportal.models.User;
import com.example.carportal.repositories.utility.DBConnector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

public class SessionService
{
    public void addListOfDamagesToSession(HttpServletRequest request) {
        ArrayList<Damage> listOfDamages = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setAttribute("listOfDamages", listOfDamages);
    }

    public User getSessionUser(HttpSession session) {
        return (User) session.getAttribute("sessionUser");
    }

    public boolean hasDamageRole(HttpSession session) {
        return getSessionUser(session).isDamageRole();
    }

    public boolean hasBusinessRole(HttpSession session) {
        return getSessionUser(session).isBusinessRole();
    }

    public boolean hasRegistrationRole(HttpSession session) {
        return getSessionUser(session).isRegistrationRole();
    }

    public void addLeaseIDToSession(HttpSession session, int leaseid) {
        session.setAttribute("leaseid", leaseid);
    }

    public int getLeaseIDFromSession(HttpSession session) {
        return (int) session.getAttribute("leaseid");
    }

    public void setDbSource(int dbSource) {
        DBConnector.setDbSource(dbSource);
    }
}
