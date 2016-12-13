/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.web;

import com.atoudeft.jdbc.Connexion;
import com.kjj.entites.Membre;
import com.kjj.implementations.MembreDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class DonneesCompte extends HttpServlet {

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
        if (request.getSession().getAttribute("connecte") != null) {
            PrintWriter out = response.getWriter();
            if (request.getParameter("somethingNew") != null) {
                Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
                MembreDao mDao = new MembreDao(Connexion.getInstance());
                Membre unMembre = 
                    mDao.find(((Membre)request.getSession().getAttribute("connecte")).getId());
                Boolean resultat = mDao.etatNotifier(unMembre.getId());
                mDao.reinitNotifier(unMembre.getId());
                out.print(resultat);

            }
            else if (request.getParameter("monId") != null) {
                out.print(((Membre)request.getSession().getAttribute("connecte")).getId());

            }
        }

            /*String  e = request.getParameter("element");
            PrintWriter out = response.getWriter();
            //GestionnaireJeu gestionnaire = new GestionnaireJeu(request);
            
            switch (e) {
                case "listeJoueurs" :
                    out.print("");
                    break;
                default :
                    out.print("");
            }*/
            
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
