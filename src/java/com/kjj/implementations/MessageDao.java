/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjj.implementations;

import com.atoudeft.jdbc.dao.Dao;
import com.kjj.entites.MessagePrive;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author soixa
 */
public class MessageDao extends Dao<MessagePrive> {
    
    public MessageDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(MessagePrive m) {
        String req = "INSERT INTO message (`idExpediteur`, `idDestinataire`, "
                + "`contenu`, `date`)"
                + "VALUES ('"+m.getIdExpediteur()+"', '"+m.getIdDestinataire()+"','"
                +m.getContenu()+"','"+m.getDate()+"')";
        String res = "SELECT LAST_INSERT_ID()";

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            ResultSet o = stm.executeQuery(res);
            if (n > 0) {
                stm.close();
                return true;
            }
            if (o.next()) {
                int hey;
                hey = o.getInt("LAST_INSERT_ID()");
                System.out.println("id : "+hey);
                o.close();
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
    public MessagePrive read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM message WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                MessagePrive m = new MessagePrive();
                m.setId(r.getInt("id"));  
                m.setIdExpediteur(r.getInt("idExpediteur"));  
                m.setIdDestinataire(r.getInt("idDestinataire"));  
                m.setContenu(r.getString("contenu"));
                m.setDate(r.getTimestamp("date"));
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
    public boolean update(MessagePrive x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(MessagePrive x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessagePrive> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<MessagePrive> findConversation(int id1, int id2) {
        List<MessagePrive> liste = new LinkedList<MessagePrive>();
        PreparedStatement stm = null;
            try 
            {
                stm = cnx.prepareStatement("SELECT m1.username expediteur, "
                        + "m2.username destinataire, message.contenu, "
                        + "message.date from message, membre m1, membre m2 "
                        + "where (idExpediteur=? and idDestinataire=? and "
                        + "m1.id=? and m2.id = ?) or (idExpediteur=? "
                        + "and idDestinataire=? and m1.id=? and m2.id = ?) "
                        + "ORDER BY date desc");
                stm.setInt(1,id1);
                stm.setInt(2,id2);
                stm.setInt(3,id1);
                stm.setInt(4,id2);
                stm.setInt(5,id2);
                stm.setInt(6,id1);
                stm.setInt(7,id2);
                stm.setInt(8,id1);
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                        MessagePrive mp = new MessagePrive(r.getString("expediteur"),
                                        r.getString("destinataire"),
                                        r.getString("contenu"),
                                        r.getTimestamp("date"));
                        liste.add(mp);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
            }
    
}


// SELECT DISTINCT idExpediteur, idDestinataire from message where (idExpediteur=24 or idDestinataire=24) ORDER BY date desc