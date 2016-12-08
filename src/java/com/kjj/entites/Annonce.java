/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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

    public Annonce(String type, Adresse adresse, LinkedHashMap specifications) {
        this.typeObjet = type;
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

    public String getTypeObjet() {
        return typeObjet;
    }

    public void setTypeObjet(String typeObjet) {
        this.typeObjet = typeObjet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LinkedList<String> getAttributsSpecs() {
        LinkedList<String> liste = new LinkedList<>();
        Set set = this.specifications.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            liste.add(""+me.getKey());
        }
        return liste;
    }
    
    public String getSpecsJSON() {
        //String[] attributs = new String[specifications.size()];
        //LinkedList<String> liste = this.getAttributsSpecs();
        Set set = this.specifications.entrySet();
        Iterator i = set.iterator();
        String json = "{";
        
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            json += "\""+me.getKey()+"\":\""+me.getValue()+"\",";
        }
        if (json != null && json.length() > 0 && json.charAt(json.length()-1)==',') {
            json = json.substring(0, json.length()-1);
        }
        json += "}";
        return json;
    }
    
    public String toJSON() {
        String json = "{\"id\":\""+this.id+"\",";
        json += "\"quantite\":\""+this.quantite+"\",";
        json += "\"titre\":\""+this.titre+"\",";
        json += "\"description\":\""+this.description+"\",";
        json += "\"typeObjet\":\""+this.typeObjet+"\",";
        json += "\"etatObjet\":\""+this.etatObjet+"\",";
        json += "\"adresse\":"+this.adresse.toJSONAnnonce()+",";
        json += "\"specifications\":"+this.getSpecsJSON()+",";
        json += "\"idMembre\":\""+this.idMembre+"\",";
        json += "\"dateCreation\":\""+this.dateCreation+"\",";
        json += "\"prix\":\""+this.prix+"\",";
        json += "\"expiree\":\""+this.expiree+"\"}";
        return json;
    }
    
}
