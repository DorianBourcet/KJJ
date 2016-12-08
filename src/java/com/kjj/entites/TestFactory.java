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
public class TestFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Membre unMembre = Factory.getMembre();
        System.out.println(unMembre.toString());
        
        Adresse uneAdresse = new Adresse("Montréal","H1T1T1","QC","Canada");
        System.out.println(uneAdresse.toJSONAnnonce());
        
        Annonce uneAnnonce = Factory.getAnnonce("automobile");
        uneAnnonce.setAdresse(uneAdresse);
        uneAnnonce.setTitre("haha");
        uneAnnonce.getSpecifications().put("Kilométrage", 120);
        uneAnnonce.getSpecifications().put("Nombre de portes", 5);
        System.out.println(uneAnnonce.toJSON());
    }
    
}
