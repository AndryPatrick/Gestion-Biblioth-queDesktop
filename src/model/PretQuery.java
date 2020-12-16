/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinot
 */
public class PretQuery {
    
    public void AjouterPret(PretGS pret){
        String sql = "insert into pret values('"+ pret.getNumPret() +"','"+ pret.getLecteurNum() +"','"+ pret.getLivreNum() +"','"+ pret.getDatePret() +"','"+ pret.getDateRetour() +"')";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erreur d'ajout! Ce prêt existe déjà");
         }
    }
    
    public void ModifierPret(PretGS pret){
        String sql = "update pret set LecteurNum = '"+ pret.getLecteurNum() +"', LivreNum = '"+ pret.getLivreNum() +"', DatePret = '"+ pret.getDatePret() +"', DateRetour = '"+ pret.getDateRetour() +"' where numPret = '"+ pret.getNumPret() +"'";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erreur de modification");
         }   
    }
    
    public void SupprimerPret(PretGS pret){
        String sql = "delete from pret where numPret = '"+ pret.getNumPret() +"'";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erreur de suppression! Ce prêt est encore éffectué");
         }
    }
    
    public ObservableList<String> getAllLecteurNum(){
        ObservableList<String> numPret = FXCollections.observableArrayList();
        String sql = "select numLecteur from lecteur ";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String i = rs.getString("numLecteur");
                numPret.add(i);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return numPret;
    }
    
    public ObservableList<String> getAllLivreNum(){
        ObservableList<String> numLivre = FXCollections.observableArrayList();
        String sql = "select numLivre from livre where Disponible = 'Oui'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                 String j = rs.getString("numLivre");
                numLivre.add(j);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return numLivre;
    }
    
    public ObservableList<PretGS> getAllPret(){
        ObservableList<PretGS> listPret = FXCollections.observableArrayList();
        String sql = "select * from pret";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                PretGS pret = new PretGS();
                pret.setNumPret(rs.getString("numPret"));
                pret.setLecteurNum(rs.getString("LecteurNum"));
                pret.setLivreNum(rs.getString("LivreNum"));
                pret.setDatePret(rs.getString("DatePret"));
                pret.setDateRetour(rs.getString("DateRetour"));
                listPret.add(pret);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
      return listPret;
    }
    
    public ObservableList<PretGS> RechercherPret(String search){
        ObservableList<PretGS> searchPret = FXCollections.observableArrayList();
        String sql = "select * from pret where numPret like '%"+ search +"%' or LecteurNum like '%"+ search +"%' or LivreNum like '%"+ search +"%' or DatePret like '%"+ search +"%' or DateRetour like '%"+ search +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                PretGS pret = new PretGS();
                pret.setNumPret(rs.getString("numPret"));
                pret.setLecteurNum(rs.getString("LecteurNum"));
                pret.setLivreNum(rs.getString("LivreNum"));
                pret.setDatePret(rs.getString("DatePret"));
                pret.setDateRetour(rs.getString("DateRetour"));
                searchPret.add(pret);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return searchPret;
    }

    public ObservableList<String> getAllNombrePret(){
        ObservableList<String> listPret = FXCollections.observableArrayList();
        String sql = "select count(numPret) from pret";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numPret)");
                listPret.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listPret;
    }
    
    public ObservableList<String> getAllNombrePretSearch(String search){
        ObservableList<String> listPret = FXCollections.observableArrayList();
        String sql = "select count(numPret) from pret where numPret like '%"+ search +"%' or LecteurNum like '%"+ search +"%' or LivreNum like '%"+ search +"%' or DatePret like '%"+ search +"%' or DateRetour like '%"+ search +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numPret)");
                listPret.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listPret;
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
