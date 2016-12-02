/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

import java.sql.Timestamp;

/**
 *
 * @author dbourcet
 */
public class Transaction {
    
    private int id;
    private int idAcheteur, idVendeur;
    private String titreAnnonce;
    private double montant;
    private Timestamp date;

    public Transaction() {
    }

    public Transaction(int id, int idAcheteur, int idVendeur, String titreAnnonce, double montant, Timestamp date) {
        this.id = id;
        this.idAcheteur = idAcheteur;
        this.idVendeur = idVendeur;
        this.titreAnnonce = titreAnnonce;
        this.montant = montant;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAcheteur() {
        return idAcheteur;
    }

    public void setIdAcheteur(int idAcheteur) {
        this.idAcheteur = idAcheteur;
    }

    public int getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(int idVendeur) {
        this.idVendeur = idVendeur;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    
}
