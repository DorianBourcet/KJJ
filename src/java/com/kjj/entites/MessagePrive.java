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
    private String contenu;
    private Timestamp date;

    public MessagePrive() {
    }

    public MessagePrive(int id, int idExpediteur, int idDestinataire, String contenu, Timestamp date) {
        this.id = id;
        this.idExpediteur = idExpediteur;
        this.idDestinataire = idDestinataire;
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

    
}
