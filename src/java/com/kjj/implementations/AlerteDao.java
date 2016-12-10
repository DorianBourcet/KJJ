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
                a.setId(r.getInt("id"));
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
    public boolean update(Alerte a) {
     Statement stm = null;
        try {
            String req = "UPDATE alerte SET "
                    + "criteresRecherche = '"+a.getCriteresRecherche()+"',"
                    +"dateDernierResultat = '"+a.getDateDernierResultat()+"'," 
                    +"idMembre = '"+a.getIdMembre()+"'"
                    +" WHERE id = '"+a.getId()+"'";
            System.out.println("REQUETE "+req);
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
    public boolean delete(Alerte a) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM alerte WHERE id='"+a.getId()+"'");
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
    public List<Alerte> findAll() {
        List<Alerte> liste = new LinkedList<Alerte>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM alerte");
		while (r.next())
		{
			
                    Alerte p = new      Alerte(r.getInt("id"),
                                        r.getString("criteresRecherche"),
                                        r.getTimestamp("dateDernierResultat"),
                                        r.getInt("idMembre"));
				liste.add(p);
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
