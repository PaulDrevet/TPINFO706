package com.example.parking;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name ="entreeServlet", value = "/entree")
public class EntreeServlet extends HttpServlet {
    @EJB
    private TicketService ticketService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        Ticket ticket = ticketService.createTicket();
        HttpSession session = request.getSession();
        session.setAttribute("ticketId", ticket.getId());

        try {
            request.getRequestDispatcher("/entree.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
