/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

/**
 *
 * @author usager
 */
import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Favori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FavoriDao extends Dao<Favori> {
    
    public FavoriDao(Connection c){
    super(c);
    }

     @Override
    public boolean create(Favori f) {
        String req = "INSERT INTO favoris (`id`, `idMembre`, `idAnnonce`)"
                + "VALUES ('"
                +f.getId()+"','"
                +f.getIdMembre()+"','"
                +f.getIdAnnonce()+"')";

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
    public Favori read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM favoris WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Favori f = new Favori();
                f.setId(r.getString("id"));  
                f.setIdMembre(r.getInt("idMembre"));  
                f.setIdAnnonce(r.getInt("idAnnonce")); 
                r.close();
                stm.close();
                return f;
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
    public boolean update(Favori x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Favori x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Favori> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
