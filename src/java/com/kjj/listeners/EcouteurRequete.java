/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.listeners;

import com.atoudeft.jdbc.Connexion;
import com.kjj.implementations.MembreDao;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *
 * @author soixa
 */
public class EcouteurRequete implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServletRequest requete = sre.getServletRequest();
        String action = null;
        if ((String)requete.getAttribute("notifierMembre") == null)
            action = "";
        else
            action = (String)requete.getAttribute("notifierMembre");
        switch (action) {
            case "message":
                Connexion.setUrl(sre.getServletContext().getInitParameter("urlBd"));
                MembreDao memDao = new MembreDao(Connexion.getInstance());
                int destinataire = (int)requete.getAttribute("idDestinataire");
                memDao.notifier(destinataire);
                return;
            default:
                return;
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("parametre haha = "+sre.getServletRequest().getParameter("haha"));
    }
    
}
