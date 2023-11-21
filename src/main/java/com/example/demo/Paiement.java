package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Paiement {
    @Id
    private Long id;
    private int montant;
    private String type;
    private String date;

    public Paiement(Long id, int montant, String type, String date) {
        this.id = id;
        this.montant = montant;
        this.type = type;
        this.date = date;
    }

    public Paiement() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getMontant() {
        return montant;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
