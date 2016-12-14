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
import com.kjj.entites.Membre;
import com.kjj.entites.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class MembreDao extends Dao<Membre> {
    
    public MembreDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Membre m) {
        String req = "INSERT INTO membre (`username`, `password`, `nom`, "
                + "`prenom`, `email`, `adresse_numero`, "
                + "`adresse_rue1`, `adresse_rue2`, `adresse_appartement`, "
                + "`adresse_ville`, `adresse_codePostal`, `adresse_province`, "
                + "`adresse_pays`)"
                + "VALUES ('"+m.getUsername()+"', '"+m.getPassword()+"','"
                +m.getNom()+"','"+m.getPrenom()+"','"+m.getEmail()+"','"
                +m.getAdresse().getNumero()+"','"
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
                    System.out.println(e.toString());
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
                Membre m = Factory.getMembre();
                m.setId(r.getInt("id"));  
                try {
                    m.setUsername(new String(r.getString("username").getBytes("UTF-8"), "ISO-8859-1"));
                    m.setPassword(r.getString("password"));  
                    m.setNom(new String(r.getString("nom").getBytes("UTF-8"), "ISO-8859-1"));
                    m.setPrenom(new String(r.getString("prenom").getBytes("UTF-8"), "ISO-8859-1"));
                    m.setEmail(r.getString("email"));  
                    m.setAvatar(r.getString("avatar"));  
                    m.getAdresse().setNumero(r.getString("adresse_numero"));  
                    m.getAdresse().setRue1(r.getString("adresse_rue1"));  
                    m.getAdresse().setRue2(r.getString("adresse_rue2"));  
                    m.getAdresse().setAppartement(r.getString("adresse_appartement"));  
                    m.getAdresse().setVille(new String(r.getString("adresse_ville").getBytes("UTF-8"), "ISO-8859-1"));
                    m.getAdresse().setCodePostal(r.getString("adresse_codePostal"));  
                    m.getAdresse().setProvince(new String(r.getString("adresse_province").getBytes("UTF-8"), "ISO-8859-1"));
                    m.getAdresse().setPays(new String(r.getString("adresse_pays").getBytes("UTF-8"), "ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                }
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
                Membre m = Factory.getMembre();
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
    
    public boolean notifier(int id) {
        Statement stm = null;
        try {
            String req = "UPDATE membre SET quoideneuf = '1'"
                    + " WHERE id = '" + id + "'";
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
    
    public boolean reinitNotifier(int id) {
        Statement stm = null;
        try {
            String req = "UPDATE membre SET quoideneuf = '0'"
                    + " WHERE id = '" + id + "'";
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
    
    public boolean etatNotifier(int id) {
        String strId = Integer.toString(id);
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT quoideneuf FROM membre WHERE id = ?");
            stm.setString(1,strId);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                if (r.getInt("quoideneuf") == 1) {
                r.close();
                stm.close();
                return true;
                }
                else {
                    r.close();
                    stm.close();
                    return false;
                }
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
    
    public List<Membre> findCorrespondants(int idMembre) {
        List<Membre> liste = new LinkedList<>();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select id, username from membre "
                        + "where id in (select idExpediteur from message "
                        + "where idDestinataire=?) or "
                        + "id in (select idDestinataire from message "
                        + "where idExpediteur=?)");
                stm.setInt(1,idMembre);
                stm.setInt(2,idMembre);
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                    Membre unCorrespondant = Factory.getMembre();
                    unCorrespondant.setId(r.getInt("id"));
                    unCorrespondant.setUsername(r.getString("username"));
                    liste.add(unCorrespondant);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
    }
    
}
