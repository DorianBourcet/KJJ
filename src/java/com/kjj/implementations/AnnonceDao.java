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
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AnnonceDao extends Dao<Annonce>{
     
    public AnnonceDao(Connection c) {
        super(c);
    }
    
    @Override
    public boolean create(Annonce a) {
        String req = "INSERT INTO annonce (`titre`, `description`, "
                + "`typeObjet`, `prix`, `adresse_ville`, `adresse_codePostal`, "
                + "`adresse_province`,`adresse_pays`, `etatObjet`, `idMembre`)"
                + "VALUES ('"
                +a.getTitre()+"','"
                +a.getDescription()+"','"
                +a.getTypeObjet()+"','"
                +a.getPrix()+"','"
                +a.getAdresse().getVille()+"','"
                +a.getAdresse().getCodePostal()+"','"
                +a.getAdresse().getProvince()+"','"
                +a.getAdresse().getPays()+"','"
                +a.getEtatObjet()+"','"
                +a.getIdMembre()+"')";

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
            if (n > 0) {
                ResultSet cle = stm.getGeneratedKeys();
                if (cle.next()) {
                    if (!(a.getTypeObjet() == null)) {
                        a.setId(cle.getInt(1));
                        if (createType(a)) {
                            stm.close();
                            return true;
                        }
                    }
                }
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
    
    private boolean createType(Annonce a) {
        String type = a.getTypeObjet();
        Set set = a.getSpecifications().entrySet();
        Iterator itr = set.iterator();
        String req = null;
        switch (type) {
            case "automobile":
                req = "INSERT INTO type_automobile (`idAnnonce`,`marque`,"
                        + "`modele`,`puissance`,`kilometrage`,`annee`,"
                        + "`carburant`,`nombrePortes`,`couleur`)"
                        + "VALUES ('"+a.getId()+"',";
                while(itr.hasNext()) {
                    Map.Entry me = (Map.Entry)itr.next();
                    req += "'"+me.getValue()+"'";
                    if (itr.hasNext())
                        req += ", ";
                }
                req += ")";
                break;
            case "cellulaire":
                req = "INSERT INTO type_cellulaire (`idAnnonce`,`marque`,"
                        + "`nomCommercial`,`modele`,`capaciteStockage`,`stockageExterne`,`typeReseau`,"
                        + "`couleur`,`systemeExploitation`,`resolutionEcran`,"
                        + "`tailleEcran`,`typeBatterie`,`capaciteBatterie`)"
                        + "VALUES ('"+a.getId()+"'";
                while(itr.hasNext()) {
                    req += ", ";
                    Map.Entry me = (Map.Entry)itr.next();
                    req += "'"+me.getValue()+"'";
                }
                req += ")";
                break;
            default:
        }

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
                Annonce a = null;
                if (!r.getString("typeObjet").equals(""))
                    a = Factory.getAnnonce(r.getString("typeObjet"));
                else
                    a = Factory.getAnnonce();
                stm = cnx.prepareStatement("SELECT * FROM annonce WHERE id = ?");
                a.setId(r.getInt("id"));  
                a.setTitre(r.getString("titre"));  
                a.setDescription(r.getString("description"));  
                a.setTypeObjet(r.getString("typeObjet"));  
                a.setPrix(r.getDouble("prix"));  
                a.getAdresse().setVille(r.getString("adresse_ville"));  
                a.getAdresse().setCodePostal(r.getString("adresse_codePostal"));  
                a.getAdresse().setProvince(r.getString("adresse_province"));  
                a.getAdresse().setPays(r.getString("adresse_pays"));
                a.setEtatObjet(r.getString("etatObjet"));
                a.setDateCreation(r.getTimestamp("date"));
                a.setIdMembre(r.getInt("idMembre"));
                if (!r.getString("typeObjet").equals("null")) {
                    Annonce resultat = readType(a);
                    r.close();
                    stm.close();
                    return resultat;
                    
                }
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
    
    private Annonce readType(Annonce a) {
        PreparedStatement stm = null;
        ResultSet r = null;
        LinkedList listeAttributs = null;
        Iterator itr = null;
        int i;
        try {
            switch (a.getTypeObjet()) {
                case "automobile":
                    stm = cnx.prepareStatement("SELECT * FROM type_automobile WHERE idAnnonce = ?");
                    stm.setString(1,""+a.getId());
                    r = stm.executeQuery();
                    listeAttributs = a.getAttributsSpecs();
                    itr = listeAttributs.iterator();
                    i = 0;
                    if (r.next()) {
                        a.getSpecifications().put(listeAttributs.get(0), r.getString(2));
                        a.getSpecifications().put(listeAttributs.get(1), r.getString(3));
                        a.getSpecifications().put(listeAttributs.get(2), r.getInt(4));
                        a.getSpecifications().put(listeAttributs.get(3), r.getInt(5));
                        a.getSpecifications().put(listeAttributs.get(4), r.getInt(6));
                        a.getSpecifications().put(listeAttributs.get(5), r.getString(7));
                        a.getSpecifications().put(listeAttributs.get(6), r.getInt(8));
                        a.getSpecifications().put(listeAttributs.get(7), r.getString(9));
                    }
                    r.close();
                    stm.close();
                    return a;
                case "cellulaire":
                    stm = cnx.prepareStatement("SELECT * FROM type_cellulaire WHERE idAnnonce = ?");
                    stm.setString(1,""+a.getId());
                    r = stm.executeQuery();
                    listeAttributs = a.getAttributsSpecs();
                    itr = listeAttributs.iterator();
                    i = 1;
                    
                    if (r.next()) {
                        a.getSpecifications().put(listeAttributs.get(0), r.getString(2));
                        a.getSpecifications().put(listeAttributs.get(1), r.getString(3));
                        a.getSpecifications().put(listeAttributs.get(2), r.getString(4));
                        a.getSpecifications().put(listeAttributs.get(3), r.getInt(5));
                        a.getSpecifications().put(listeAttributs.get(4), r.getString(6));
                        a.getSpecifications().put(listeAttributs.get(5), r.getString(7));
                        a.getSpecifications().put(listeAttributs.get(6), r.getString(8));
                        a.getSpecifications().put(listeAttributs.get(7), r.getString(9));
                        a.getSpecifications().put(listeAttributs.get(8), r.getString(10));
                        a.getSpecifications().put(listeAttributs.get(9), r.getFloat(11));
                        a.getSpecifications().put(listeAttributs.get(10), r.getString(12));
                        a.getSpecifications().put(listeAttributs.get(11), r.getInt(13));
                    }
                    r.close();
                    stm.close();
                    return a;
                default:
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
    public boolean update(Annonce a) {
     Statement stm = null;
        try {
            String req = "UPDATE annonce SET "
                +"titre = '"+a.getTitre()+"'," 
                +"description = '"+a.getDescription()+"'," 
                +"prix = '"+a.getPrix()+"',"
                +"adresse_ville = '"+a.getAdresse().getVille()+"',"
                +"adresse_codePostal = '"+a.getAdresse().getCodePostal()+"',"
                +"adresse_province = '"+a.getAdresse().getProvince()+"',"
                +"adresse_pays = '"+a.getAdresse().getPays()+"',"
                +"etatObjet = '"+a.getEtatObjet()+"'"
                +" WHERE id = '"+a.getId()+"'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                if (!a.getTypeObjet().equals("")) {
                    if (updateType(a)) {
                        stm.close();
                        return true;
                    }
                }
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
    
    private boolean updateType(Annonce a) {
        Statement stm = null;
        Set set = a.getSpecifications().entrySet();
        Iterator itr = set.iterator();
        Map.Entry me = null;
        String req = null;
        try {
            switch (a.getTypeObjet()) {
                case "automobile":
                    req = "UPDATE type_automobile SET ";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "marque = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "modele = '"+me.getValue()+"'," ;
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req+= "puissance = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "kilometrage = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "annee = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req +="carburant = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "nombrePortes = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "couleur = '"+me.getValue()+"'";
                    req += " WHERE idAnnonce = '"+a.getId()+"'";
                    break;
                case "cellulaire":
                    req = "UPDATE type_cellulaire SET ";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "marque = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "nomCommercial = '"+me.getValue()+"'," ;
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req+= "modele = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "capaciteStockage = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "stockageExterne = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req +="typeReseau = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "couleur = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "systemeExploitation = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "resolutionEcran = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "tailleEcran = '"+me.getValue()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "typeBatterie = '"+a.getEtatObjet()+"',";
                    itr.hasNext();
                    me = (Map.Entry)itr.next();
                    req += "capaciteBatterie = '"+me.getValue()+"'";
                    req += " WHERE idAnnonce = '"+a.getId()+"'";
                    break;
                default:
            }
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
    
    public List<Annonce> findAllLimit(int numPage) {
        List<Annonce> liste = new LinkedList<>();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select * from annonce "
                        + "Order by 1 desc LIMIT ?, 16");
                stm.setInt(1,numPage);
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                    Annonce uneAnnonce = Factory.getAnnonce();
                    uneAnnonce.setId(r.getInt("id"));
                    try {
                        uneAnnonce.setTitre(new String (r.getString("titre").getBytes("UTF-8"), "ISO-8859-1"));
                        uneAnnonce.setDescription(new String(r.getString("description").getBytes("UTF-8"), "ISO-8859-1"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    uneAnnonce.setDateCreation(r.getTimestamp("date"));
                    uneAnnonce.setTypeObjet(r.getString("typeObjet"));
                    uneAnnonce.setPrix(r.getDouble("prix"));
                    //uneAnnonce.getAdresse().setVille(r.getString("ville"));
                    liste.add(uneAnnonce);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
    }
    
    public List<Annonce> findByMembreLimit(int numPage, int idMembre) {
        List<Annonce> liste = new LinkedList<>();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select * from annonce WHERE idMembre = ? "
                        + "Order by 1 desc LIMIT ?, 16");
                stm.setInt(2,numPage);
                stm.setInt(1,idMembre);
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                    Annonce uneAnnonce = Factory.getAnnonce();
                    uneAnnonce.setId(r.getInt("id"));
                    try {
                        uneAnnonce.setTitre(new String (r.getString("titre").getBytes("UTF-8"), "ISO-8859-1"));
                        uneAnnonce.setDescription(new String(r.getString("description").getBytes("UTF-8"), "ISO-8859-1"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    uneAnnonce.setDateCreation(r.getTimestamp("date"));
                    uneAnnonce.setTypeObjet(r.getString("typeObjet"));
                    uneAnnonce.setPrix(r.getDouble("prix"));
                    //uneAnnonce.getAdresse().setVille(r.getString("ville"));
                    liste.add(uneAnnonce);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
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


