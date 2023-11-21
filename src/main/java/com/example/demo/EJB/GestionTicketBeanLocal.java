package com.example.demo.EJB;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

@Stateless
@Local(GestionTicketBeanLocal.class)
public interface GestionTicketBeanLocal {

    void createTicket(String dateEntree, String dateSortie, String montant);

}
