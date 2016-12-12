/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.web;

import com.atoudeft.jdbc.Connexion;
import com.kjj.entites.Annonce;
import com.kjj.entites.Membre;
import com.kjj.implementations.AnnonceDao;
import com.kjj.implementations.MembreDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dbourcet
 */
public class ConsultationAnnonce extends HttpServlet {

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
        AnnonceDao adao = new AnnonceDao(Connexion.getInstance());
        //out.println("servlet édition annonce (nouvelle ou existante)");
        if (request.getParameter("idAnnonce") != null) {
            String idAnnonce = request.getParameter("idAnnonce");
            Annonce uneAnnonce = adao.read(idAnnonce);
            if (uneAnnonce != null) {
                MembreDao mdao = new MembreDao(Connexion.getInstance());
                Membre unMembre = mdao.find(uneAnnonce.getIdMembre());
                String jsonResponse = "["+uneAnnonce.toJSON()+","+unMembre.toJSON()+"]";
                out.println(jsonResponse);
                return;
            }
            else {
                out.println("");
                return;
            }
        }
        else if (request.getParameter("page") != null) {
            int numPage = Integer.parseInt(request.getParameter("page"));
            int indexDebut = numPage*16-16;
            List<Annonce> liste = new LinkedList<>();
            liste = adao.findAllLimit(indexDebut);
            Iterator itr = liste.iterator();
            System.out.println(liste);
            String listeJson = "[";
            while (itr.hasNext()) {
                listeJson += ((Annonce)itr.next()).toJSON();
                if (itr.hasNext())
                    listeJson += ",";
            }
            listeJson += ",{\"numPage\":\""+numPage+"\"}]";
            out.println(listeJson);
            return;
        }
        else {
            List<Annonce> liste = new LinkedList<>();
            liste = adao.findAllLimit(0);
            Iterator itr = liste.iterator();
            System.out.println(liste);
            String listeJson = "{\"annonce\":[";
            while (itr.hasNext()) {
                listeJson += ((Annonce)itr.next()).toJSON();
                if (itr.hasNext())
                    listeJson += ",";
            }
            listeJson += "],\"page\":[{\"numPage\":\"1\"}]}";
            out.println(listeJson);
            return;
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
