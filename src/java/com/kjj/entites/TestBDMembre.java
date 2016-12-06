/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

import com.atoudeft.jdbc.Connexion;
import com.kjj.implementations.MembreDao;
import com.kjj.implementations.MessageDao;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author soixa
 */
public class TestBDMembre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion.setUrl("jdbc:mysql://localhost/kijiji2?user=root&password=root");
        MessageDao md = new MessageDao(Connexion.getInstance());
        Calendar calendrier = Calendar.getInstance();
        Date maintenant = calendrier.getTime();
        Timestamp currentTimestamp = new Timestamp(maintenant.getTime());
        MessagePrive mp = new MessagePrive(24,25,"Ceci est un message test hahahah",currentTimestamp);
        //md.create(mp);
        
        MessagePrive test = md.read("1");
        if(test != null)
            System.out.println("done");
        
        /*HashMap donneesObligatoires = new HashMap();
        donneesObligatoires.put("usr",m.getUsername());
        donneesObligatoires.put("pwd",m.getPassword());
        donneesObligatoires.put("nom",m.getNom());
        donneesObligatoires.put("prn",m.getPrenom());
        donneesObligatoires.put("ema",m.getAdresse().getRue1());
        Set set = donneesObligatoires.entrySet();
        Iterator itr = set.iterator();
        while(itr.hasNext()) {
         Map.Entry entry = (Map.Entry)itr.next();
         if (entry.getValue().equals(""))
             System.out.println("Dodo!!!");
        }
        //m.setUsername("Dodo2");
        if (!md.create(m))
        {
            // Erreur lors de la création (membre existant)
            System.out.println("non créé");
        }
        else
            // Membre créé
            System.out.println("créé");*/
    }
    
}
