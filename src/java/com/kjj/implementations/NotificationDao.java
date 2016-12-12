/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

/**
 *
 * @author ali
 */

import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class NotificationDao extends Dao<Notification>{
    
    public NotificationDao(Connection c){
        super(c);
    }

    @Override
    public boolean create(Notification not) {
        String req = "INSERT INTO notification (`id`, "
                + "`type`, `titre`, `idMembre`)"
                + "VALUES ('"
                +not.getId()+"','"
                +not.getType()+"','"
                +not.getTitre()+"','"
                +not.getIdMembre()+"')";

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
    public Notification read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM notification WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Notification n = new Notification();
                n.setId(r.getInt("id"));  
                n.setType(r.getString("type"));  
                n.setTitre(r.getString("titre"));  
                n.setIdMembre(r.getInt("idMembre"));
                r.close();
                stm.close();
                return n;
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
    public boolean update(Notification no) {
     Statement stm = null;
        try {
            String req = "UPDATE notification SET "
                    + "type = '"+no.getType()+"',"
                    +"titre = '"+no.getTitre()+"'," 
                    +"idMembre = '"+no.getIdMembre()+"'"
                    +" WHERE id = '"+no.getId()+"'";
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
    public boolean delete(Notification no) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM notification WHERE id='"+no.getId()+"'");
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
    public List<Notification> findAll() {
        List<Notification> liste = new LinkedList<Notification>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM notification");
		while (r.next())
		{
			
                    Notification n = new      Notification(r.getInt("id"),
                                        r.getInt("idMembre"),
                                        r.getString("type"),
                                        r.getString("titre")
                                        );
				liste.add(n);
			}
			r.close();
			stm.close();
		}
		catch (SQLException exp)
		{
		}
		return liste;
    }
    
     public List<Notification> findAllByMembre(int idMembre) {
        List<Notification> liste = new LinkedList<Notification>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM notification where"
                        + " idMembre = "+idMembre+" Order by id desc");
		while (r.next())
		{
			
                    Notification n = new Notification(r.getInt("id"),
                                        r.getInt("idMembre"),
                                        r.getString("type"),
                                        r.getString("titre")
                                        );
				liste.add(n);
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
