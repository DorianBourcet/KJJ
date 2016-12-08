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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author soixa
 */
public class TestsDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion.setUrl("jdbc:mysql://localhost/kijiji2?user=root&password=root");
        MessageDao md = new MessageDao(Connexion.getInstance());
        /*Calendar calendrier = Calendar.getInstance();
        Date maintenant = calendrier.getTime();
        Timestamp currentTimestamp = new Timestamp(maintenant.getTime());
        MessagePrive mp = new MessagePrive(24,25,"Ceci est un message test hahahah",currentTimestamp);
        //md.create(mp);
        
        MessagePrive test = md.read("1");
        if(test != null)
            System.out.println(test.toJSON());*/
        
        /*Annonce uneAnnonce = Factory.getAnnonce("automobile");
        uneAnnonce.getSpecifications().put("Kilométrage", 120);
        uneAnnonce.getSpecifications().put("Nombre de portes", 5);
        System.out.println(uneAnnonce.getSpecifications().get("Nombre de portes"));
        // Get a set of the entries
      Set set = uneAnnonce.getSpecifications().entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
        
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }*/
        List liste = new LinkedList();
        liste = md.findConversation(24, 25);
        for (int i=0;i<liste.size();i++)
            System.out.println(((MessagePrive)liste.get(i)).toJSON());
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
