package com.example.parking;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name ="paiementServlet", value = "/paiement")
public class PaiementServlet extends HttpServlet {
    @EJB
    private TicketService ticketService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String valeurBouton = request.getParameter("boutonSubmit");
        System.out.println(valeurBouton);

        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("ticketId");
        Ticket ticket = ticketService.getTicket(id);

        Paiement paiement = new Paiement(valeurBouton, 2.5, ticket);
        ticket.addPaiement(paiement);
        ticketService.updateTicket(ticket);

        System.out.println(ticket.getPaiement());

        try {
            request.getRequestDispatcher("/entree.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("ticketId");
        if (id == null) {
            request.setAttribute("ticket", null);
        }
        else{
            Ticket ticket = ticketService.getTicket(id);
            request.setAttribute("ticket", ticket);
        }

        try {
            request.getRequestDispatcher("/paiement.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
