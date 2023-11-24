package com.example.parking;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
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

    public Date getLastDatePaiement(){
        return this.paiements.get(paiements.size() - 1).getDatePaiement();
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

    public double calculerMontant(){
        double montant = 0;
        Date now = new Date();
        if (this.dateSortie != null){
            throw new IllegalStateException("Vous êtes deja sorti");
        }
        Duration duration;
        if (this.paiements.isEmpty()){
            duration = Duration.between(this.dateEntree.toInstant(), now.toInstant());
        }
        else{
            Date dernierPaiment = this.paiements.get(paiements.size() - 1).getDatePaiement();
            duration = Duration.between(dernierPaiment.toInstant(), now.toInstant());
        }
        montant = duration.toSeconds() * 0.03;
        BigDecimal montantArrondi = BigDecimal.valueOf(montant).setScale(2, RoundingMode.HALF_UP);

        return montantArrondi.doubleValue();
    }

    public double calculerTotal(){
        double montant = 0;
        for (Paiement paiement : this.paiements){
            System.out.println(paiement.getMontant());
            montant += paiement.getMontant();
        }
        return montant;
    }

    public boolean canExit(){
        if (this.paiements.isEmpty()) {
            return false;
        }
        else {
            Duration duration;
            Date now = new Date();
            Date dernierPaiment = this.paiements.get(paiements.size() - 1).getDatePaiement();
            duration = Duration.between(dernierPaiment.toInstant(), now.toInstant());
            return duration.toSeconds() < 30;
        }
    }
}