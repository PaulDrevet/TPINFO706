package com.example.parking;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class TicketService {
    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Ticket createTicket() {
        Ticket ticket = new Ticket();
        entityManager.persist(ticket);
        return ticket;
    }
    public TicketService(){}

    // Autres méthodes de gestion des tickets
}