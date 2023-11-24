package com.example.parking;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;
    private double montant;

    private String typePaiement;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Paiement(){
    }

    public Paiement(String typePaiement, double montant, Ticket ticket) {
        this.datePaiement = new Date();
        this.typePaiement = typePaiement;
        this.montant = montant;
        this.ticket = ticket;
    }
}
