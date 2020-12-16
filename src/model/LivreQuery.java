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
public class LivreQuery {
    
    public void AjouterLivre(LivreGS livre ){
        String sql = "insert into livre values('"+ livre.getNumLivre() +"','"+ livre.getDesignation() +"','"+ livre.getTitre() +"','"+ livre.getAuteur() +"','"+ livre.getDateEdition() +"','"+ livre.getDisponible() +"','1')";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erreur d'ajout! un exemplaire de Ce livre existe déjà");
         }
    }
    
    public void ModifierLivre(LivreGS livre){
        String sql = "update livre set Designation = '"+ livre.getDesignation() +"', Titre = '"+ livre.getTitre() +"', Auteur = '"+ livre.getAuteur() +"', Date_Edition = '"+ livre.getDateEdition() +"', Disponible = '"+ livre.getDisponible() +"' WHERE numLivre = '"+ livre.getNumLivre() +"'";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erreur de modification");
         }
    }
    
    public void SupprimerLivre(LivreGS livre){
        String sql = "delete from livre where numLivre = '"+ livre.getNumLivre() +"'";
        try{
             ConnectDB con = new ConnectDB();
             con.Connect().createStatement().execute(sql);
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Erreur de suppression! Ce livre est encore prêté");
         }
    }
    
    public ObservableList<LivreGS> getAllLivre(){
        ObservableList<LivreGS> listLivre = FXCollections.observableArrayList();
        String sql = "select * from livre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                LivreGS livre = new LivreGS();
                livre.setNumLivre(rs.getString("numLivre"));
                livre.setDesignation(rs.getString("Designation"));
                livre.setTitre(rs.getString("Titre"));
                livre.setAuteur(rs.getString("Auteur"));
                livre.setDateEdition(rs.getString("Date_Edition"));
                livre.setDisponible(rs.getString("Disponible"));
                listLivre.add(livre);
            }
        }catch(SQLException ex){
            System.err.println("mis diso");
        }
      return listLivre;
    }

    public ObservableList<LivreGS> RechercherLivre(String id){
        ObservableList<LivreGS> list = FXCollections.observableArrayList();
        String sql = "select * from livre where numLivre like '%"+ id +"%' or Designation like '%"+ id +"%' or Titre like '%"+ id +"%' or Auteur like '%"+ id +"%' or Date_Edition like '%"+ id +"%' or Disponible like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                LivreGS livre = new LivreGS();
                livre.setNumLivre(rs.getString("numLivre"));
                livre.setDesignation(rs.getString("Designation"));
                livre.setTitre(rs.getString("Titre"));
                livre.setAuteur(rs.getString("Auteur"));
                livre.setDateEdition(rs.getString("Date_Edition"));
                livre.setDisponible(rs.getString("Disponible"));
                list.add(livre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return list;
    }
    
    public ObservableList<LivreGS> getTitreLivre(String id){
        ObservableList<LivreGS> listTitle = FXCollections.observableArrayList();
        String sql = "select * from livre where Designation like '%"+ id +"%' or Titre like '%"+ id +"%' or Auteur like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                LivreGS livre = new LivreGS();
                livre.setNumLivre(rs.getString("numLivre"));
                livre.setDesignation(rs.getString("Designation"));
                livre.setTitre(rs.getString("Titre"));
                livre.setAuteur(rs.getString("Auteur"));
                livre.setDateEdition(rs.getString("Date_Edition"));
                livre.setDisponible(rs.getString("Disponible"));
                listTitle.add(livre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return listTitle;
    }
    
    public ObservableList<String> getAllNombreLivre(){
        ObservableList<String> listLivre = FXCollections.observableArrayList();
        String sql = "select sum(NbFoisPret) from livre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombreLivre = rs.getString("sum(NbFoisPret)");
                listLivre.add(nombreLivre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public ObservableList<String> getAllNombreLivreGeneralSearch(String id){
        ObservableList<String> listLivre = FXCollections.observableArrayList();
        String sql = "select sum(NbFoisPret) from livre where numLivre like '%"+ id +"%' or Designation like '%"+ id +"%' or Titre like '%"+ id +"%' or Auteur like '%"+ id +"%' or Date_Edition like '%"+ id +"%' or Disponible like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombreLivre = rs.getString("sum(NbFoisPret)");
                listLivre.add(nombreLivre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public ObservableList<String> getAllNombreLivreTitAutSearch(String id){
        ObservableList<String> listLivre = FXCollections.observableArrayList();
        String sql = "select sum(NbFoisPret) from livre where Designation like '%"+ id +"%' or Titre like '%"+ id +"%' or Auteur like '%"+ id +"%'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                String nombreLivre = rs.getString("sum(NbFoisPret)");
                listLivre.add(nombreLivre);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public ResultSet ExecuteFetchQuery(String sql) {
       ResultSet rs = null;
        try{
           ConnectDB con = new ConnectDB();
           rs = con.Connect().createStatement().executeQuery(sql);
       }catch(SQLException ex){
           System.err.println("executequery diso");
       }
      return rs;
    }
    

}
