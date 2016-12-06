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
    }
    
}
