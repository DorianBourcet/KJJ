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

    
}
