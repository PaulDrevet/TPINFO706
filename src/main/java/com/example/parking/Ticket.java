package com.example.parking;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSortie;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Paiement> paiements;


    public Date getDateEntree() {
        return dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie() {
        this.dateSortie = new Date();
    }

    public void addPaiement(Paiement paiement){
        this.paiements.add(paiement);
    }

    public List<Paiement> getPaiement(){
        return this.paiements;
    }

    public Long getId() {
        return id;
    }

    public Ticket (){
        this.dateEntree = new Date();
        this.dateSortie = null;
    }
}