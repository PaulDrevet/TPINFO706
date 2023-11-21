package com.example.parking;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="ticketServlet", value = "/ticket")
public class TicketServlet extends HttpServlet {
    @EJB
    private TicketService ticketService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Récupérer les données du formulaire
        // Créer une instance de Ticket
        // Configurer les propriétés du ticket

        // Appeler la méthode de TicketService pour créer un nouveau ticket
        ticketService.createTicket();

        // Rediriger ou afficher une réponse à l'utilisateur
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


        Ticket ticket = ticketService.createTicket();
        request.setAttribute("ticket", ticket);

        try {
            request.getRequestDispatcher("/ticket.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
        // Configurer les propriétés du ticket

        // Appeler la méthode de TicketService pour créer un nouveau ticket

        // Rediriger ou afficher une réponse à l'utilisateur
    }
}
