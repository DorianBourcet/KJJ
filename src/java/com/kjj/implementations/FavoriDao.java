/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

/**
 *
 * @author Ali
 */

import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Favori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class FavoriDao extends Dao<Favori> {
    
    public FavoriDao(Connection c){
    super(c);
    }

     @Override
    public boolean create(Favori f) {
        String req = "INSERT INTO favoris (`idMembre`, `idAnnonce`)"
                + "VALUES ('"
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
                f.setId(r.getInt("id"));  
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
    public boolean update(Favori f) {
     Statement stm = null;
        try {
            String req = "UPDATE favoris SET "
                            +"idMembre = '"+f.getIdMembre()+"'," 
                            +"idAnnonce = '"+f.getIdAnnonce()+"'," 
                            +" WHERE id = '"+f.getId()+"'";
            //System.out.println("REQUETE "+req);
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
    public boolean delete(Favori f) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM favoris WHERE id='"+f.getId()+"'");
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
    public List<Favori> findAll() {
        List<Favori> liste = new LinkedList<Favori>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM evaluation");
		while (r.next())
		{
			
                    Favori f = new Favori(r.getInt("id"),                                   
                                        r.getInt("idMembre"),
                                        r.getInt("idAnnonce"));
				liste.add(f);
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
