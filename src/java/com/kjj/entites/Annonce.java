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
public class Annonce {
    
    private int id;
    private String titre, description, etatObjet;
    private Adresse adresse;
    private String[][] champs; // <À repenser, peut-être avec Map
    private int idMembre;
    private Timestamp dateCreation;
    private boolean expiree;

    public Annonce() {
    }

    public Annonce(int id, String titre, String description, String etatObjet, Adresse adresse, String[][] champs, int idMembre, Timestamp dateCreation, boolean expiree) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etatObjet = etatObjet;
        this.adresse = adresse;
        this.champs = champs;
        this.idMembre = idMembre;
        this.dateCreation = dateCreation;
        this.expiree = expiree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtatObjet() {
        return etatObjet;
    }

    public void setEtatObjet(String etatObjet) {
        this.etatObjet = etatObjet;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String[][] getChamps() {
        return champs;
    }

    public void setChamps(String[][] champs) {
        this.champs = champs;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isExpiree() {
        return expiree;
    }

    public void setExpiree(boolean expiree) {
        this.expiree = expiree;
    }

    
    
    
    
}
