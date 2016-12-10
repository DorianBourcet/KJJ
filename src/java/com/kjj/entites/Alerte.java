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
    
    private int id;
    private String criteresRecherche;
    private Timestamp dateDernierResultat;
    private int idMembre;

    public Alerte() {
    }

    public Alerte(int id,String criteresRecherche, 
                Timestamp dateDernierResultat,int idMembre) {
        this.id = id;
        this.criteresRecherche = criteresRecherche;
        this.dateDernierResultat = dateDernierResultat;
        this.idMembre = idMembre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return ("id:"+this.getId()+", criteres: "+this.getCriteresRecherche()+""
                + ", date:"+this.getDateDernierResultat()+", membre"+this.getIdMembre());
    }
    
}
