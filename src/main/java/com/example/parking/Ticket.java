package com.example.parking;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSortie;


    public Date getDateEntree() {
        return dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie() {
        this.dateSortie = new Date();
    }

    public Long getId() {
        return id;
    }

    public Ticket (){
        this.dateEntree = new Date();
        this.dateSortie = null;
    }

    public String toString(){
        return "oui";
         }
}