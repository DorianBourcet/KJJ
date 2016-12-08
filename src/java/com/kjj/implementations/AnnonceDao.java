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
import com.kjj.entites.Annonce;
import com.kjj.entites.Adresse;
import com.kjj.entites.Factory;
import com.kjj.entites.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class AnnonceDao extends Dao<Annonce>{
     
    public AnnonceDao(Connection c) {
        super(c);
    }
    
    public boolean create(Annonce a) {
        String req = "INSERT INTO annonce (`id`, `titre`, `description`, "
                + "`typeObjet`, `prix`,`adresse_ville`, `adresse_codePostal`, "
                + "`adresse_province`,`adresse_pays`, `etatObjet`, `date`, `idMembre`)"
                + "VALUES ('"
                +a.getId()+"', '"
                +a.getTitre()+"','"
                +a.getDescription()+"','"
                +a.getTypeObjet()+"','"
                +a.getPrix()+"','"
                +a.getAdresse().getVille()+"','"
                +a.getAdresse().getCodePostal()+"','"
                +a.getAdresse().getProvince()+"','"
                +a.getAdresse().getPays()+"','"
                +a.getEtatObjet()+"','"
                +a.getDateCreation()+"','"
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
    
    public boolean createType(Annonce a) {
        
        // À CODER !!!
        String req = "INSERT INTO annonce (`id`, `titre`, `description`, "
                + "`typeObjet`, `prix`,`adresse_ville`, `adresse_codePostal`, "
                + "`adresse_province`,`adresse_pays`, `etatObjet`, `date`, `idMembre`)"
                + "VALUES ('"
                +a.getId()+"', '"
                +a.getTitre()+"','"
                +a.getDescription()+"','"
                +a.getTypeObjet()+"','"
                +a.getPrix()+"','"
                +a.getAdresse().getVille()+"','"
                +a.getAdresse().getCodePostal()+"','"
                +a.getAdresse().getProvince()+"','"
                +a.getAdresse().getPays()+"','"
                +a.getEtatObjet()+"','"
                +a.getDateCreation()+"','"
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
    public Annonce read(String id) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce WHERE id = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Annonce a = Factory.getAnnonce();
                a.setId(r.getInt("id"));  
                a.setTitre(r.getString("titre"));  
                a.setDescription(r.getString("description"));  
                a.setTypeObjet(r.getString("typeObjet"));  
                a.setTypeObjet(r.getString("prix"));  
                a.getAdresse().setVille(r.getString("adresse_ville"));  
                a.getAdresse().setCodePostal(r.getString("adresse_codePostal"));  
                a.getAdresse().setProvince(r.getString("adresse_province"));  
                a.getAdresse().setPays(r.getString("adresse_pays"));
                a.setEtatObjet(r.getString("etatObjet"));
                a.setDateCreation(r.getTimestamp("date"));
                a.setIdMembre(r.getInt("idMembre"));
             // a.setExpiree(r.getBoolean("etat"));
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

   /* @Override
    public List<Annonce> findAll() {
        List<Annonce> liste = new LinkedList<Annonce>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM user");
            while (r.next()) {
                Annonce a = new Annonce(r.getInt("id"), r.getString("titre"),
                        r.getString("description"), r.getString("typeObjet"),
                        r.getString("",));
                liste.add(a);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }*/
    
    public Annonce find(int id) {
        String strId = Integer.toString(id);
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM annonce WHERE id = ?");
            stm.setString(1,strId);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Annonce a = Factory.getAnnonce();
                a.setId(r.getInt("id"));  
                a.setTitre(r.getString("titre"));  
                a.setDescription(r.getString("description"));  
                a.setTypeObjet(r.getString("typeObjet"));
                a.setTypeObjet(r.getString("prix")); 
                a.getAdresse().setVille(r.getString("adresse_ville"));  
                a.getAdresse().setCodePostal(r.getString("adresse_codePostal"));  
                a.getAdresse().setProvince(r.getString("adresse_province"));  
                a.getAdresse().setPays(r.getString("adresse_pays"));
                a.setEtatObjet(r.getString("etatObjet"));
                a.setDateCreation(r.getTimestamp("date"));
                a.setIdMembre(r.getInt("idMembre"));
             // a.setExpiree(r.getBoolean("etat"));
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
    public boolean update(Annonce x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Annonce x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


