/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Thinot
 */
public class OuvrageQuery {
 
    
    
  public ObservableList<OuvrageGS> getAllOuvrage(){
         ObservableList<OuvrageGS> listOuvrage = FXCollections.observableArrayList();
         String sql = "select numLecteur,nom,Designation,Titre,Auteur,Date_Edition,DatePret,DateRetour,DATE_ADD(DatePret, INTERVAL 8 DAY) AS DateExpiration from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum order by numLecteur";
         ResultSet rs = ExecuteFetchQuery(sql);
         
        try{
            while(rs.next()){
                OuvrageGS ouvrage = new OuvrageGS();
                ouvrage.setNumLecteur(rs.getString("numLecteur"));
                ouvrage.setNom(rs.getString("nom"));
                ouvrage.setDesignation(rs.getString("Designation"));
                ouvrage.setTitre(rs.getString("Titre"));
                ouvrage.setAuteur(rs.getString("Auteur"));
                ouvrage.setDateEdition(rs.getString("Date_Edition"));
                ouvrage.setDatePret(rs.getString("DatePret"));
                ouvrage.setDateRetour(rs.getString("DateRetour"));
                if((ouvrage.getDateRetour().equals(rs.getString("DateExpiration")))){
                    ouvrage.setAmende("5000(fmg)");
                }
                listOuvrage.add(ouvrage);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
      return listOuvrage;
     }
  
  public ObservableList<String> getAllNombrePret(){
         ObservableList<String> listOuvrage = FXCollections.observableArrayList();
         String sql = "select count(numLecteur) from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum order by numLecteur";
         ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listOuvrage.add(nombre);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
      return listOuvrage;
     }
  
  public ObservableList<String> getAllNombrePretYear(String yearslist){
        ObservableList<String> listOuvrage = FXCollections.observableArrayList();
        String sql = "select count(numLecteur) from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and year(DatePret) = '"+ yearslist +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listOuvrage.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
  
  public ObservableList<String> getAllNombrePretYearMonth(String monthlist, String yearlist){
        ObservableList<String> listOuvrage = FXCollections.observableArrayList();
        String sql = "select count(numLecteur) from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and month(DatePret) = '"+ monthlist +"' and year(DatePret) = '"+ yearlist +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listOuvrage.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
  
  public ObservableList<String> getAllNombrePretBetwenTwoDate(String datPretDeb,String datPretFin){
        ObservableList<String> listOuvrage = FXCollections.observableArrayList();
        String sql = "select count(numLecteur) from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and DatePret between '"+ datPretDeb +"' and '"+ datPretFin +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listOuvrage.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
  
  public ObservableList<OuvrageGS> RechercherOuvrage(String datPretDeb,String datPretFin){
        ObservableList<OuvrageGS> listOuvrage = FXCollections.observableArrayList();
        String sql = "select numLecteur,nom,Designation,Titre,Auteur,Date_Edition,DatePret,DateRetour,DATE_ADD(DatePret, INTERVAL 8 DAY) AS DateExpiration from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and DatePret between '"+ datPretDeb +"' and '"+ datPretFin +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                OuvrageGS ouvrage = new OuvrageGS();
                ouvrage.setNumLecteur(rs.getString("numLecteur"));
                ouvrage.setNom(rs.getString("nom"));
                ouvrage.setDesignation(rs.getString("Designation"));
                ouvrage.setTitre(rs.getString("Titre"));
                ouvrage.setAuteur(rs.getString("Auteur"));
                ouvrage.setDateEdition(rs.getString("Date_Edition"));
                ouvrage.setDatePret(rs.getString("DatePret"));
                ouvrage.setDateRetour(rs.getString("DateRetour"));
                if((ouvrage.getDateRetour().equals(rs.getString("DateExpiration")))){
                    ouvrage.setAmende("5000(fmg)");
                }
                listOuvrage.add(ouvrage);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
    
    public ObservableList<OuvrageGS> getYearsOuvrageList(String yearslist){
        ObservableList<OuvrageGS> listOuvrage = FXCollections.observableArrayList();
        String sql = "select numLecteur,nom,Designation,Titre,Auteur,Date_Edition,DatePret,DateRetour,DATE_ADD(DatePret, INTERVAL 8 DAY) AS DateExpiration from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and year(DatePret) = '"+ yearslist +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                OuvrageGS ouvrage = new OuvrageGS();
                ouvrage.setNumLecteur(rs.getString("numLecteur"));
                ouvrage.setNom(rs.getString("nom"));
                ouvrage.setDesignation(rs.getString("Designation"));
                ouvrage.setTitre(rs.getString("Titre"));
                ouvrage.setAuteur(rs.getString("Auteur"));
                ouvrage.setDateEdition(rs.getString("Date_Edition"));
                ouvrage.setDatePret(rs.getString("DatePret"));
                ouvrage.setDateRetour(rs.getString("DateRetour"));
                if((ouvrage.getDateRetour().equals(rs.getString("DateExpiration")))){
                    ouvrage.setAmende("5000(fmg)");
                }
                listOuvrage.add(ouvrage);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
  
    public ObservableList<OuvrageGS> getYearsMonthOuvrageList(String monthlist, String yearlist){
        ObservableList<OuvrageGS> listOuvrage = FXCollections.observableArrayList();
        String sql = "select numLecteur,nom,Designation,Titre,Auteur,Date_Edition,DatePret,DateRetour,DATE_ADD(DatePret, INTERVAL 8 DAY) AS DateExpiration from lecteur,livre,pret where numLecteur = lecteurNum and numLivre = livreNum and month(DatePret) = '"+ monthlist +"' and year(DatePret) = '"+ yearlist +"' order by numLecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                OuvrageGS ouvrage = new OuvrageGS();
                ouvrage.setNumLecteur(rs.getString("numLecteur"));
                ouvrage.setNom(rs.getString("nom"));
                ouvrage.setDesignation(rs.getString("Designation"));
                ouvrage.setTitre(rs.getString("Titre"));
                ouvrage.setAuteur(rs.getString("Auteur"));
                ouvrage.setDateEdition(rs.getString("Date_Edition"));
                ouvrage.setDatePret(rs.getString("DatePret"));
                ouvrage.setDateRetour(rs.getString("DateRetour"));
                if((ouvrage.getDateRetour().equals(rs.getString("DateExpiration")))){
                    ouvrage.setAmende("5000(fmg)");
                }
                listOuvrage.add(ouvrage);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listOuvrage;
    }
    
    public ResultSet ExecuteFetchQuery(String sql) {
        ResultSet rs = null;
        try{
            ConnectDB con = new ConnectDB();
            rs = con.Connect().createStatement().executeQuery(sql);
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return rs;
    }
     
}
