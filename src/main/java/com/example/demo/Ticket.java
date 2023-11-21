package com.example.demo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@NamedQueries({
        @NamedQuery(name = "allTickets",
                query = "select t from Ticket t"),
    })
@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private String dateEntree;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_sortie", nullable = false)
    private String dateSortie;
    @Transient
    private String montant;
    @OneToMany(mappedBy = "ticket")
    private ArrayList<Paiement> paiements;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Ticket(Long id, String dateEntree, String dateSortie, String montant) {
        this.id = id;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.montant = montant;
        this.paiements = new ArrayList<Paiement>();
    }

    public Ticket() {

    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDateEntree() {
        return dateEntree;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getMontant() {
        return montant;
    }

    public void setPaiements(ArrayList<Paiement> paiements) {
        this.paiements = paiements;
    }

    public ArrayList<Paiement> getPaiements() {
        return paiements;
    }

    public void addPaiement(Paiement paiement) {
        paiements.add(paiement);
    }

    public void removePaiement(Paiement paiement) {
        paiements.remove(paiement);
    }

    public void removeAllPaiements() {
        paiements.clear();
    }

    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", dateEntree='" + dateEntree + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", montant='" + montant + '\'' +
                ", paiements=" + paiements +
                '}';
    }
}
