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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dbourcet
 */
public class Login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*PrintWriter out = response.getWriter();
        out.println("servlet login");
        request.getSession(true).setAttribute("connecte", "Toto");
        out.println(request.getSession().getAttribute("connecte")+" vous êtes connecté !");*/
        String  u = request.getParameter("username"),
                p = request.getParameter("password");
        if (u==null || u.trim().equalsIgnoreCase(""))
        {
            request.setAttribute("message", "Nom d'utilisateur obligatoire");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
            return;
        }

        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        MembreDao dao = new MembreDao(Connexion.getInstance());
        Membre m = dao.read(u.trim());
        
        if (m == null)
        {
            // Membre inconnu dans la BD
            out.print("0");
        }
        else if (!m.getPassword().equals(p))
        {
            // Mot de pase erronné
            out.print("2");
        }
        else
        {
            // Connexion OK
            HttpSession session = request.getSession(true);
            session.setAttribute("connecte", u);
            request.setAttribute("haha", "haha");
            RequestDispatcher rd = this.getServletContext()
                    .getNamedDispatcher("changements");
            rd.include(request, response);
            out.print("1");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
