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
import com.kjj.entites.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TransactionDao extends Dao<Transaction>{
 
     public TransactionDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Transaction t) {
        String req = "INSERT INTO transaction (`idAcheteur`, "
                + "`idVendeur`, `titreAnnonce`, `montant`, `date`)"
                + "VALUES ('"
                +t.getIdAcheteur()+"','"
                +t.getIdVendeur()+"','"
                +t.getTitreAnnonce()+"','"
                +t.getMontant()+"','"
                +t.getDate()+"')";

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
    public Transaction read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM transaction WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Transaction t = new Transaction();
                t.setId(r.getInt("id"));  
                t.setIdAcheteur(r.getInt("idAcheteur"));  
                t.setIdVendeur(r.getInt("idVendeur"));  
                t.setTitreAnnonce(r.getString("titreAnnonce"));
                t.setMontant(r.getDouble("montant"));
                t.setDate(r.getTimestamp("date"));
                r.close();
                stm.close();
                return t;
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
    public boolean update(Transaction t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Transaction t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaction> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
