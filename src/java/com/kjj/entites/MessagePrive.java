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
public class MessagePrive {
    
    private int id;
    private int idExpediteur, idDestinataire;
    private String expediteur, destinataire;
    private String contenu;
    private Timestamp date;
    private int lu;

    public MessagePrive() {
    }

    public MessagePrive(int id, int idExpediteur, int idDestinataire, String contenu, Timestamp date) {
        this.id = id;
        this.idExpediteur = idExpediteur;
        this.idDestinataire = idDestinataire;
        this.contenu = contenu;
        this.date = date;
    }

    public MessagePrive(int idExpediteur, int idDestinataire, String contenu, Timestamp date) {
        this.idExpediteur = idExpediteur;
        this.idDestinataire = idDestinataire;
        this.contenu = contenu;
        this.date = date;
    }
    
    public MessagePrive(String expediteur, String destinataire, String contenu, Timestamp date) {
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.contenu = contenu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExpediteur() {
        return idExpediteur;
    }

    public void setIdExpediteur(int idExpediteur) {
        this.idExpediteur = idExpediteur;
    }

    public int getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(int idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getLu() {
        return lu;
    }

    public void setLu(int lu) {
        this.lu = lu;
    }
    
    public String toJSON() {
        return "{\"expediteur\":\""+this.expediteur
                +"\",\"destinataire\":\""+this.destinataire
                +"\",\"contenu\":\""+this.contenu
                +"\",\"date\":\""+this.date
                +"\",\"lu\":\""+this.lu
                +"\"}";
    }

    
}
