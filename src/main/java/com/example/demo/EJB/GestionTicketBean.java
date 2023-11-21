
package com.example.demo.EJB;

import com.example.demo.JPA.TicketService;
import com.example.demo.Paiement;
import com.example.demo.Ticket;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class GestionTicketBean implements GestionTicketBeanLocal{

    private TicketService ticketService;

    @Override
    public void createTicket(String dateEntree, String dateSortie, String montant) {
        ticketService = new TicketService();
        Ticket ticket = new Ticket();
        ticket.setDateEntree(dateEntree);
        ticket.setDateSortie(dateSortie);
        ticket.setMontant(montant);
        ticketService.createTicket(ticket);
    }

    public void deleteTicket(Long id) {
        ticketService.deleteTicket(id);
    }

    public Ticket findTicket(Long id) {
        return ticketService.findTicket(id);
    }

    public List<Ticket> findAllTickets() {
        return ticketService.findAllTickets();
    }

    public Paiement getLastPaiement(Long id) {
        return ticketService.getLastPaiement(id);
    }

    public void addPaiement(Long idTicket, int montant, String type, String date) {
        Ticket ticket = ticketService.findTicket(idTicket);
        Paiement paiement = new Paiement();
        paiement.setMontant(montant);
        paiement.setType(type);
        paiement.setDate(date);
        ticket.addPaiement(paiement);
        ticketService.updateTicket(ticket);
    }
}
