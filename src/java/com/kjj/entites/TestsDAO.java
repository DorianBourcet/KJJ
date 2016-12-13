/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.entites;

import com.atoudeft.jdbc.Connexion;
import com.kjj.implementations.AnnonceDao;
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
        //MessageDao md = new MessageDao(Connexion.getInstance());
        /*Calendar calendrier = Calendar.getInstance();
        Date maintenant = calendrier.getTime();
        Timestamp currentTimestamp = new Timestamp(maintenant.getTime());
        MessagePrive mp = new MessagePrive(24,25,"Ceci est un message test hahahah",currentTimestamp);
        //md.create(mp);
        
        MessagePrive test = md.read("1");
        if(test != null)
            System.out.println(test.toJSON());*/
        
        Annonce uneAnnonce = Factory.getAnnonce();
        /*uneAnnonce.getSpecifications().put("Marque", "Sony");
        uneAnnonce.getSpecifications().put("Nom commercial", "Galaxy S II");
        uneAnnonce.getSpecifications().put("Modèle", "GT-I9100");
        uneAnnonce.getSpecifications().put("Capacité de stockage", 16);
        uneAnnonce.getSpecifications().put("Stockage externe", "MicroSD");
        uneAnnonce.getSpecifications().put("Type de réseau", "HSPA+");
        uneAnnonce.getSpecifications().put("Couleur", "Noir");
        uneAnnonce.getSpecifications().put("Système d'exploitation", "Android 4.1");
        uneAnnonce.getSpecifications().put("Résolution d'écran", "480*800");
        uneAnnonce.getSpecifications().put("Taille d'écran", 4.3);
        uneAnnonce.getSpecifications().put("Type de batterie", "Li-ion");
        uneAnnonce.getSpecifications().put("Capacité de batterie", 2300);*/
        uneAnnonce.setAdresse(new Adresse("Montréal","H1T1T1","QC","Canada"));
        uneAnnonce.setTitre("Horloge murale");
        uneAnnonce.setDescription("Horloge murale à affichage numérique");
        uneAnnonce.setPrix(100);
        uneAnnonce.setEtatObjet("occasion");
        Calendar calendrier = Calendar.getInstance();
        Date maintenant = calendrier.getTime();
        Timestamp currentTimestamp = new Timestamp(maintenant.getTime());
        uneAnnonce.setDateCreation(currentTimestamp);
        uneAnnonce.setIdMembre(25);
        AnnonceDao adao = new AnnonceDao(Connexion.getInstance());
        /*Annonce uneAnnonce = adao.read("20");
        uneAnnonce.setTitre("GalaxyS2");
        uneAnnonce.setTypeObjet("");*/
        //uneAnnonce.getSpecifications().put("Marque", "Samsung");
        //System.out.println(uneAnnonce.toJSON());
        if (adao.create(uneAnnonce))
            System.out.println("created");
        else
            System.out.println("not created");
        //System.out.println(uneAnnonce.getSpecifications().get("Nombre de portes"));
        // Get a set of the entries
      Set set = uneAnnonce.getSpecifications().entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      /*while(i.hasNext()) {
        
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }*/
        
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
