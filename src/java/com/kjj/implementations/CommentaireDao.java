/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

/**
 *
 * @author usager
 */import java.sql.Timestamp;
import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CommentaireDao extends Dao<Commentaire>{
    public CommentaireDao(Connection c){
        super(c);
    }

     @Override
    public boolean create(Commentaire c) {
        String req = "INSERT INTO commentaire (`id`, `contenu`, `idMembre`, "
                + "`date`)"
                + "VALUES ('"
                +c.getId()+"','"
                +c.getContenu()+"','"
                +c.getIdMembre()+"','"
                +c.getDate()+"')";

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
    public Commentaire read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM commentaire WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Commentaire c = new Commentaire();
                c.setId(r.getInt("id"));  
                c.setContenu(r.getString("contenu"));  
                c.setIdMembre(r.getInt("idMembre")); 
                c.setDate(r.getTimestamp("date")); 
                r.close();
                stm.close();
                return c;
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
    public boolean update(Commentaire c) {
     Statement stm = null;
        try {
            String req = "UPDATE commentaire SET "
                    + "contenu = '"+c.getContenu()+"',"
                    +"idMembre = '"+c.getIdMembre()+"'," 
                    +"date = '"+c.getDate()+"'"
                    +" WHERE id = '"+c.getId()+"'";
           // System.out.println("REQUETE "+req);
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
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
        return false;
    }

    @Override
    public boolean delete(Commentaire c) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM commentaire WHERE id='"+c.getId()+"'");
		if (n>0)
		{
			stm.close();
			return true;
		}
	}
	catch (SQLException exp)
	{
	}
	finally
	{
		if (stm!=null)
		try {
			stm.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	return false;
    }

    @Override
    public List<Commentaire> findAll() {
        List<Commentaire> liste = new LinkedList<Commentaire>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM commentaire");
		while (r.next())
		{
			
                    Commentaire c = new      Commentaire(r.getInt("id"),
                                        r.getString("contenu"),
                                        r.getInt("idMembre"),
                                        r.getTimestamp("date"));
				liste.add(c);
			}
			r.close();
			stm.close();
		}
		catch (SQLException exp)
		{
		}
		return liste;
    }
    
}
