/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

/**
 *
 * @author soixa
 */
public class MembreFactory {
    
    public static Membre getMembre() {
        return new Membre(new Adresse("Canada"));
    }
    
    public static Membre getMembre(String username, String password, String nom,
            String prenom, String email, String adr_numero, String adr_rue1,
            String adr_rue2, String adr_appartement, String adr_ville,
            String adr_codePostal, String adr_province) {
        return new Membre(username, password, nom, prenom, email,
                new Adresse(adr_numero, adr_rue1, adr_rue2, adr_appartement,
                        adr_ville, adr_codePostal, adr_province, "Canada"));
    }

    
}
