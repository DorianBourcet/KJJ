/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.web;

import com.atoudeft.jdbc.Connexion;
import com.kjj.entites.Annonce;
import com.kjj.entites.Factory;
import com.kjj.implementations.AnnonceDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
public class EditionAnnonce extends HttpServlet {

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
        //out.println("servlet édition annonce (nouvelle ou existante)");
        if (request.getParameter("idAnnonce") != null) {
            if (!request.getParameter("titre").equals("")) {
                String idAnnonce = request.getParameter("idAnnonce");
                AnnonceDao adao = new AnnonceDao(Connexion.getInstance());
                Annonce annonceModifiable = adao.read(idAnnonce);
                if (annonceModifiable != null) {
                    LinkedList listeAttributs = annonceModifiable.getAttributsSpecs();
                    Annonce annonceEditee = null;
                    if (!annonceModifiable.getTypeObjet().equals(""))
                        Factory.getAnnonce(annonceModifiable.getTypeObjet());
                    else
                        Factory.getAnnonce();
                    annonceEditee.setTitre(request.getParameter("titre"));
                    annonceEditee.setDescription(request.getParameter("description"));
                    annonceEditee.setTypeObjet(request.getParameter("typeObjet"));
                    annonceEditee.setEtatObjet(request.getParameter("etatObjet"));
                    annonceEditee.setPrix(Integer.parseInt(request.getParameter("prix")));
                    annonceEditee.getAdresse().setVille(request.getParameter("ville"));
                    annonceEditee.getAdresse().setCodePostal(request.getParameter("codePostal"));
                    annonceEditee.getAdresse().setProvince(request.getParameter("province"));
                    switch (annonceModifiable.getTypeObjet()) {
                        case "automobile":
                            annonceEditee.getSpecifications().put(listeAttributs.get(0), request.getParameter("marque"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(1), request.getParameter("modele"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(2), request.getParameter("puissance"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(3), request.getParameter("kilometrage"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(4), request.getParameter("annee"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(5), request.getParameter("carburant"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(6), request.getParameter("nombrePortes"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("couleur"));
                            break;
                        case "cellulaire":
                            annonceEditee.getSpecifications().put(listeAttributs.get(0), request.getParameter("marque"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(1), request.getParameter("nomCommercial"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(2), request.getParameter("modele"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(3), request.getParameter("capaciteStockage"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(4), request.getParameter("stockageExterne"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(5), request.getParameter("typeReseau"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(6), request.getParameter("couleur"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("systemeExploitation"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("resolutionEcran"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("tailleEcran"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("typeBatterie"));
                            annonceEditee.getSpecifications().put(listeAttributs.get(7), request.getParameter("capaciteBatterie"));
                            break;
                        default:
                    }
                    if (adao.update(annonceEditee)) {
                        out.print("1"); // Annonce éditée avec succès
                        return;
                    }
                    else {
                        out.print("2"); // Annonce non éditée
                        return;
                    }

                }
                else {
                    out.println("0"); // Annonce non trouvée dans la BD
                    return;
                }
            }
            else {
                out.println("3"); // Champs titre incorrect (vide)
                    return;
            }
        }
        else {
            // Création d'annonce à faire
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
