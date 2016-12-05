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
public class Adresse {

    private String numero;
    private String rue1;
    private String rue2;
    private String appartement;
    private String ville;
    private String codePostal;
    private String province;
    private String pays;

    public Adresse() {
    }

    public Adresse(String pays) {
        this.pays = pays;
    }
    
    public Adresse(String numero, String rue1, String rue2, String appartement, String ville, String codePostal, String province, String pays) {
        this.numero = numero;
        this.rue1 = rue1;
        this.rue2 = rue2;
        this.appartement = appartement;
        this.ville = ville;
        this.codePostal = codePostal;
        this.province = province;
        this.pays = pays;
    }

    /*public Adresse(String pays) {
        this.pays = pays;
    }*/

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue1() {
        return rue1;
    }

    public void setRue1(String rue1) {
        this.rue1 = rue1;
    }

    public String getRue2() {
        return rue2;
    }

    public void setRue2(String rue2) {
        this.rue2 = rue2;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    @Override
    public String toString() {
        return numero+" "+rue1+"\n"
                +rue2+" "+appartement+"\n"
                +ville+" "+codePostal+" "+province+" "+pays;
    }
}
