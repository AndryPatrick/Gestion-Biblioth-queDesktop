/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.sql.*;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinot
 */
public class LecteurQuery {
    
    public void AjouterLecteur(LecteurGS lecteur){
        String sql = "insert into lecteur values('"+ lecteur.getNumero() +"','"+ lecteur.getNom() +"')";
        try{
            ConnectDB conn = new ConnectDB();
            conn.Connect().createStatement().execute(sql);
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erreur d'Ajout! Ce lecteur existe déjà");
         }
    }
    
    public void ModifierLecteur(LecteurGS lecteur){
        String sql = "update lecteur set nom = '"+ lecteur.getNom() +"' where numLecteur = '"+ lecteur.getNumero() +"'";
        try{
            ConnectDB conn = new ConnectDB();
            conn.Connect().createStatement().execute(sql);
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erreur de modification! Le numero ne peut pas être modifié");
         }
    }
    
    public void SupprimerLecteur(LecteurGS lecteur){
        String sql = "delete from lecteur where numLecteur = '"+ lecteur.getNumero() +"'";
        try{
            ConnectDB conn = new ConnectDB();
            conn.Connect().createStatement().execute(sql);
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erreur de suppression! Ce lecteur prêt encore de livre");
         }
    }
    
   
    
    public ObservableList<LecteurGS> RechercherLecteur(String id){
        ObservableList<LecteurGS> list = FXCollections.observableArrayList();
        String sql = "select * from lecteur where numLecteur like '%"+ id +"%' or nom like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                LecteurGS lecteur = new LecteurGS();
                lecteur.setNumero(rs.getString("numLecteur"));
                lecteur.setNom(rs.getString("nom"));
                list.add(lecteur);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ObservableList<LecteurGS> getAllLecteur(){
        ObservableList<LecteurGS> list = FXCollections.observableArrayList();
        String sql = "select * from lecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                LecteurGS lecteur = new LecteurGS();
                lecteur.setNumero(rs.getString("numLecteur"));
                lecteur.setNom(rs.getString("nom"));
                list.add(lecteur);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }

    public ObservableList<String> getAllNombreLecteur(){
        ObservableList<String> listLecteur = FXCollections.observableArrayList();
        String sql = "select count(numLecteur) from lecteur";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listLecteur.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLecteur;
    }
    
    public ObservableList<String> getAllNombreLecteurSearch(String id){
        ObservableList<String> listLecteur = FXCollections.observableArrayList();
        String sql = "select count(numLecteur) from lecteur where numLecteur like '%"+ id +"%' or nom like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombre = rs.getString("count(numLecteur)");
                listLecteur.add(nombre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLecteur;
    }
    
    private ResultSet ExecuteFetchQuery(String sql) {
        ResultSet rs = null;
        try{
             ConnectDB conn = new ConnectDB();
             rs = conn.Connect().createStatement().executeQuery(sql);
         } catch(SQLException ex){
             System.err.println(ex.getMessage());
         }
       return rs;
    }
    
}
