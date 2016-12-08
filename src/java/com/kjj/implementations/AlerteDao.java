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
import java.sql.Timestamp;
import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Alerte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AlerteDao extends Dao<Alerte>{

    public AlerteDao(Connection c){
        super(c);
    }
  
     @Override
    public boolean create(Alerte a) {
        String req = "INSERT INTO alerte (`criteresRecherche`, "
                + "`dateDernierResultat`, `idMembre`)"
                + "VALUES ('"
                +a.getCriteresRecherche()+"','"
                +a.getDateDernierResultat()+"','"
                +a.getIdMembre()+"')";

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
    public Alerte read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM alerte WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Alerte a = new Alerte();
                a.setCriteresRecherche(r.getString("criteresRecherche"));  
                a.setDateDernierResultat(r.getTimestamp("dateDernierResultat"));  
                a.setIdMembre(r.getInt("idMembre")); 
                r.close();
                stm.close();
                return a;
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
    public boolean update(Alerte x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Alerte x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alerte> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
