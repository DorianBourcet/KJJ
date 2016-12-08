/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.web;

import com.atoudeft.jdbc.Connexion;
import com.kjj.entites.Membre;
import com.kjj.entites.MessagePrive;
import com.kjj.implementations.MembreDao;
import com.kjj.implementations.MessageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dbourcet
 */
public class Contact extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        PrintWriter out = response.getWriter();
        
        if (request.getParameter("destinataire") != null) {
            int destinataire = Integer.parseInt((String)request.getParameter("destinataire"));
            String contenu = request.getParameter("contenu");
            MembreDao memDao = new MembreDao(Connexion.getInstance());
            //Membre m = dao.read(u.trim());

            Membre membreExp = 
                    memDao.read((String)request.getSession().getAttribute("connecte"));
            Membre membreDes = memDao.find(destinataire);
            if (membreDes == null || membreExp == null)
                out.println(false);
            else {
                Calendar calendrier = Calendar.getInstance();
                Date maintenant = calendrier.getTime();
                Timestamp currentTimestamp = new Timestamp(maintenant.getTime());
                
                MessagePrive mp = new MessagePrive(membreExp.getId(),
                        membreDes.getId(), contenu, currentTimestamp);

                MessageDao messDao = new MessageDao(Connexion.getInstance());
                if (!messDao.create(mp))
                {
                    // Erreur lors de la création du message
                    out.print(false);
                }
                else {
                    // Message créé
                    request.setAttribute("idDes", membreDes.getId());
                    RequestDispatcher rd = this.getServletContext()
                        .getNamedDispatcher("changements");
                    rd.include(request, response);
                    out.print(true);
                }
            }
        }
        else if (request.getParameter("conversation") != null) {
            int idCorrespondant = 
                    Integer.parseInt(request.getParameter("conversation"));
            MembreDao memDao = new MembreDao(Connexion.getInstance());
            Membre mbreConnecte = 
                    memDao.read((String)request.getSession().getAttribute("connecte"));
            MessageDao messDao = new MessageDao(Connexion.getInstance());
            List<MessagePrive> listeMessages = messDao.findConversation(mbreConnecte.getId(), idCorrespondant);
            String listeJson = "[";
            ListIterator itr = listeMessages.listIterator();
            while (itr.hasNext()) {
                listeJson += ((MessagePrive)itr.next()).toJSON();
                if (itr.hasNext())
                    listeJson += ", ";
            }
            listeJson += "]";
            out.print(listeJson);
        }
        else {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
