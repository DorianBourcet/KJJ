/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

/**
 *
 * @author usager
 */
public class Favori {
    
    private int id, idMembre, idAnnonce;

    public Favori() {
    }

    public Favori(int id, int idMembre, int idAnnonce) {
        this.id = id;
        this.idMembre = idMembre;
        this.idAnnonce = idAnnonce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
