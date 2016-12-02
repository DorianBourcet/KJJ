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
public class AnnoncePro extends Annonce {
    
    private int quantite;

    public AnnoncePro() {
    }

    public AnnoncePro(int id, String titre, String description, String etatObjet, Adresse adresse, String[][] champs, int idMembre, Timestamp dateCreation, boolean expiree) {
        super(id, titre, description, etatObjet, adresse, champs, idMembre, dateCreation, expiree);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
}
