package com.example.demo.JPA;

import com.example.demo.Paiement;
import com.example.demo.Ticket;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.*;

import java.util.List;

@TransactionManagement(TransactionManagementType.BEAN)
public class TicketService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TicketJpaUnit");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    public void createTicket(Ticket ticket) {
        em.persist(ticket);
    }

    public void updateTicket(Ticket ticket) {
        em.merge(ticket);
    }

    public Ticket findTicket(Long id) {
        return em.find(Ticket.class, id);
    }

    public List<Ticket> findAllTickets() {
        Query req = em.createNamedQuery("allTickets");
        System.out.println(req.getResultList());
        return req.getResultList();
    }

    public Paiement getLastPaiement(Long id) {
        return em.find(Paiement.class, id);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = em.find(Ticket.class, id);
        if (ticket != null) {
            em.remove(ticket);
        }
    }
}
