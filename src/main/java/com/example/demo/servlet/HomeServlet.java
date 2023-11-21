package com.example.demo.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeServlet", value = "/home-servlet")
public class HomeServlet extends jakarta.servlet.http.HttpServlet{

    @EJB
    private com.example.demo.EJB.GestionTicketBean gestionTicketBean;

    public void init() {
        gestionTicketBean = new com.example.demo.EJB.GestionTicketBean();
        gestionTicketBean.createTicket("2021-01-01", "2021-01-01", "10");
        gestionTicketBean.createTicket("2021-01-01", "2021-01-01", "10");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("tickets", gestionTicketBean.findAllTickets());
        request.getRequestDispatcher("/HomeServlet.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
