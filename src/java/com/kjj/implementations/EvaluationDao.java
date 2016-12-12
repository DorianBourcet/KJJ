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
import com.kjj.entites.Evaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class EvaluationDao extends Dao<Evaluation>{
    
    public EvaluationDao(Connection c){
        super(c);
    }
    
    @Override
    public boolean create(Evaluation ev) {
        String req = "INSERT INTO evaluation (`id`, "
                + "`contenu`, `note`, `idMembre`, `idAnnonce`)"
                + "VALUES ('"
                +ev.getId()+"','"
                +ev.getContenu()+"','"
                +ev.getNote()+"','"
                +ev.getIdMembre()+"','"
                +ev.getIdAnnonce()+"')";

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
    public Evaluation read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM evaluation WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Evaluation ev = new Evaluation();
                ev.setId(r.getInt("id"));  
                ev.setContenu(r.getString("contenu"));  
                ev.setNote(r.getInt("note"));  
                ev.setIdMembre(r.getInt("idMembre"));
                ev.setIdAnnonce(r.getInt("idAnnonce"));
                r.close();
                stm.close();
                return ev;
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
    public boolean update(Evaluation ev) {
     Statement stm = null;
        try {
            String req = "UPDATE evaluation SET "
                    + "contenu = '"+ev.getContenu()+"',"
                    + "note = '"+ev.getNote()+"',"
                    +"idMembre = '"+ev.getIdMembre()+"'," 
                    +"idAnnonce = '"+ev.getIdAnnonce()+"'," 
                    +" WHERE id = '"+ev.getId()+"'";
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
    public boolean delete(Evaluation ev) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM evaluation WHERE id='"+ev.getId()+"'");
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
    public List<Evaluation> findAll() {
        List<Evaluation> liste = new LinkedList<Evaluation>();
            try 
		{
		Statement stm = cnx.createStatement(); 
		ResultSet r = stm.executeQuery("SELECT * FROM evaluation");
		while (r.next())
		{
			
                    Evaluation ev = new Evaluation(r.getInt("id"),
                                        r.getString("contenu"),
                                        r.getInt("note"),
                                        r.getInt("idMembre"),
                                        r.getInt("idAnnonce"));
				liste.add(ev);
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
