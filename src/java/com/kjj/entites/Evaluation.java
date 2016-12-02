/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

/**
 *
 * @author dbourcet
 */
public class Evaluation {
    
    private int id;
    private String contenu;
    private int note;
    private int idMembre;
    private int idAnnonce;

    public Evaluation() {
    }

    public Evaluation(int id, String contenu, int note, int idMembre, int idAnnonce) {
        this.id = id;
        this.contenu = contenu;
        this.note = note;
        this.idMembre = idMembre;
        this.idAnnonce = idAnnonce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    
    
    
}
