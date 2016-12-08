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
import java.sql.Timestamp;

public class Alerte {
    
    private String criteresRecherche;
    private Timestamp dateDernierResultat;
    private int idMembre;

    public Alerte() {
    }

    public Alerte(String criteresRecherche, Timestamp dateDernierResultat) {
        this.criteresRecherche = criteresRecherche;
        this.dateDernierResultat = dateDernierResultat;
    }

    public String getCriteresRecherche() {
        return criteresRecherche;
    }

    public void setCriteresRecherche(String criteresRecherche) {
        this.criteresRecherche = criteresRecherche;
    }

    public Timestamp getDateDernierResultat() {
        return dateDernierResultat;
    }

    public void setDateDernierResultat(Timestamp dateDernierResultat) {
        this.dateDernierResultat = dateDernierResultat;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }
    
    
    
}
