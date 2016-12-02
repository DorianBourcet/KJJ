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
public class Alerte {
    
    private String criteresRecherche, dateDernierResultat;

    public Alerte() {
    }

    public Alerte(String criteresRecherche, String dateDernierResultat) {
        this.criteresRecherche = criteresRecherche;
        this.dateDernierResultat = dateDernierResultat;
    }

    public String getCriteresRecherche() {
        return criteresRecherche;
    }

    public void setCriteresRecherche(String criteresRecherche) {
        this.criteresRecherche = criteresRecherche;
    }

    public String getDateDernierResultat() {
        return dateDernierResultat;
    }

    public void setDateDernierResultat(String dateDernierResultat) {
        this.dateDernierResultat = dateDernierResultat;
    }
    
    
    
}
