package com.example.parking.Servlet;

import com.example.parking.Paiement;
import com.example.parking.Ticket;
import com.example.parking.TicketService;
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

        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("ticketId");
        Ticket ticket = ticketService.getTicket(id);

        if (valeurBouton.equals("Recapitulatif paiement")){
            request.setAttribute("ticket_id", ticket.getId());
            request.setAttribute("total", ticket.calculerTotal());
            request.setAttribute("date_entree", ticket.getDateEntree());
            if (ticket.getPaiement().isEmpty()){
                request.setAttribute("date_paiement", null);
                request.setAttribute("typePaiement", null);
                request.setAttribute("aPaye", false);
            }
            else{
                request.setAttribute("date_paiement", ticket.getLastDatePaiement());
                request.setAttribute("typePaiement", ticket.getLastTypePaiement());
                request.setAttribute("aPaye", true);
            }
            try {
                request.getRequestDispatcher("/recapitulatif.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Paiement paiement = new Paiement(valeurBouton, ticket.calculerMontant(), ticket);
            System.out.println(paiement.getTypePaiement());
            ticket.addPaiement(paiement);
            ticketService.updateTicket(ticket);
            try {
                request.getRequestDispatcher("/entree.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
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
            double montant = ticket.calculerMontant();

            request.setAttribute("montant", montant);
            request.setAttribute("ticket", ticket);
        }

        try {
            request.getRequestDispatcher("/paiement.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
