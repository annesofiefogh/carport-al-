package com.example.carportal.services;

import com.example.carportal.models.User;

import javax.servlet.http.HttpSession;

public class SessionService
{
    public User getSessionUser(HttpSession session){
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

    public void addLeaseIdToSession(HttpSession session, int leaseid) {
        session.setAttribute("leaseid", leaseid);
    }

    public int getLeaseIdFromSession(HttpSession session) {
        return (int) session.getAttribute("leaseid");
    }
}
