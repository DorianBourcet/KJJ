/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

/**
 *
 * @author dbourcet
 */
public class Annonce {
    
    private int id, quantite;
    private String titre, description,typeObjet ,etatObjet;
    private Adresse adresse;
    private LinkedHashMap specifications;
    private int idMembre;
    private Timestamp dateCreation;
    private double prix;
    private boolean expiree;

    public Annonce() {
    }

    public Annonce(Adresse adresse) {
        this.adresse = adresse;
    }

    public Annonce(Adresse adresse, LinkedHashMap specifications) {
        this.adresse = adresse;
        this.specifications = specifications;
    }

    public Annonce(int id, int quantite, String titre, String description,
                    String typeObjet ,String etatObjet, double prix, 
                    Adresse adresse, LinkedHashMap specifications, int idMembre,
                    Timestamp dateCreation, boolean expiree) {
        this.id = id;
        this.quantite = quantite;
        this.titre = titre;
        this.description = description;
        this.typeObjet = typeObjet ;
        this.etatObjet = etatObjet;
        this.prix = prix;
        this.adresse = adresse;
        this.specifications = specifications;
        this.idMembre = idMembre;
        this.dateCreation = dateCreation;
        this.expiree = expiree;
    }
    
    public Annonce(int id, String titre, String description, String typeObjet,
                    String etatObjet, double prix, Adresse adresse, int idMembre,
                    Timestamp dateCreation, boolean expiree) {
        this.id = id;
        this.quantite = 1;
        this.titre = titre;
        this.description = description;
        this.typeObjet = typeObjet ;
        this.etatObjet = etatObjet;
        this.prix = prix;
        this.adresse = adresse;
        //this.champs = [][]champs;
        this.idMembre = idMembre;
        this.dateCreation = dateCreation;
        this.expiree = expiree;
    }
        
    public Annonce(int id, String titre, String description,String typeObjet, 
                    String etatObjet, double prix, Adresse adresse, 
                    LinkedHashMap specifications, int idMembre,
                    Timestamp dateCreation, boolean expiree) {
        this.id = id;
        this.quantite = 1;
        this.titre = titre;
        this.description = description;
        this.typeObjet = typeObjet ;
        this.etatObjet = etatObjet;
        this.prix = prix;
        this.adresse = adresse;
        this.specifications = specifications;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    public LinkedHashMap getSpecifications() {
        return specifications;
    }

    public void setSpecifications(LinkedHashMap specifications) {
        this.specifications = specifications;
    }

    
    
    
    
}
