/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Membre;
import com.kjj.entites.MembreFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author soixa
 */
public class MembreDao extends Dao<Membre> {
    
    public MembreDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Membre m) {
        String req = "INSERT INTO membre (`username`, `password`, `nom`, "
                + "`prenom`, `email`, `avatar`, `adresse_numero`, "
                + "`adresse_rue1`, `adresse_rue2`, `adresse_appartement`, "
                + "`adresse_ville`, `adresse_codePostal`, `adresse_province`, "
                + "`adresse_pays`)"
                + "VALUES ('"+m.getUsername()+"', '"+m.getPassword()+"','"
                +m.getNom()+"','"+m.getPrenom()+"','"+m.getEmail()+"','"
                +m.getAvatar()+"','"+m.getAdresse().getNumero()+"','"
                +m.getAdresse().getRue1()+"','"+m.getAdresse().getRue2()+"','"
                +m.getAdresse().getAppartement()+"','"
                +m.getAdresse().getVille()+"','"
                +m.getAdresse().getCodePostal()+"','"
                +m.getAdresse().getProvince()+"','"
                +m.getAdresse().getPays()+"')";

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public Membre read(String usr) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membre WHERE username = ?");
            stm.setString(1,usr);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Membre m = MembreFactory.getMembre();
                m.setId(r.getInt("id"));  
                m.setUsername(r.getString("username"));  
                m.setPassword(r.getString("password"));  
                m.setNom(r.getString("nom"));  
                m.setPrenom(r.getString("prenom"));  
                m.setEmail(r.getString("email"));  
                m.setAvatar(r.getString("avatar"));  
                m.getAdresse().setNumero(r.getString("adresse_numero"));  
                m.getAdresse().setRue1(r.getString("adresse_rue1"));  
                m.getAdresse().setRue2(r.getString("adresse_rue2"));  
                m.getAdresse().setAppartement(r.getString("adresse_appartement"));  
                m.getAdresse().setVille(r.getString("adresse_ville"));  
                m.getAdresse().setCodePostal(r.getString("adresse_codePostal"));  
                m.getAdresse().setProvince(r.getString("adresse_province"));  
                m.getAdresse().setPays(r.getString("adresse_pays"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Membre> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Membre find(int id) {
        String strId = Integer.toString(id);
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membre WHERE id = ?");
            stm.setString(1,strId);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Membre m = MembreFactory.getMembre();
                m.setId(r.getInt("id"));  
                m.setUsername(r.getString("username"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
}
