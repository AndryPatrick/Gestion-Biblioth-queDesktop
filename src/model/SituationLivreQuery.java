/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
import javafx.collections.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Thinot
 */
public class SituationLivreQuery {
  
    //SituationLivreQuery Action Begin
    public ObservableList<SituationLivreGS> getAllSituationLivre(){
        ObservableList<SituationLivreGS> listLivre = FXCollections.observableArrayList();
        String sql = "select numLivre,Designation,Titre,Auteur,Date_Edition,Disponible,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by numLivre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                SituationLivreGS situation = new SituationLivreGS();
                situation.setNumLivre(rs.getString("numLivre"));
                situation.setDesignation(rs.getString("Designation"));
                situation.setTitre(rs.getString("Titre"));
                situation.setAuteur(rs.getString("Auteur"));
                situation.setDateEdition(rs.getString("Date_Edition"));
                situation.setDisponible(rs.getString("Disponible"));
                situation.setNbFoisPret(rs.getString("sum(NbFoisPret)"));
                listLivre.add(situation);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public ObservableList<PieChart.Data> DiagrammeCirculaireLivreSituation(){
        ObservableList<PieChart.Data> listLivre = FXCollections.observableArrayList();
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by numLivre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                PieChart.Data data = new PieChart.Data(rs.getString("Designation"), new Integer(rs.getString("sum(NbFoisPret)")));
                listLivre.add(data);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public BarChart<String, Number> DiagrammeBattonLivreSituation(CategoryAxis xAxis, NumberAxis yAxis){
        BarChart<String, Number> listLivre = new BarChart<>(xAxis,yAxis);
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by numLivre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                XYChart.Series series = new XYChart.Series();
                series.setName(rs.getString("Designation"));
                series.getData().add(new XYChart.Data(rs.getString("Designation"),new Integer(rs.getString("sum(NbFoisPret)"))));
                listLivre.getData().add(series);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public LineChart<String, Number> DiagrammeLineaireLivreSituation(CategoryAxis xAxis, NumberAxis yAxis){
        LineChart<String, Number> listLivre = new LineChart<String, Number>(xAxis,yAxis);
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by numLivre";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                XYChart.Series series = new XYChart.Series();
                series.getData().add(new XYChart.Data(rs.getString("Designation"), new Integer(rs.getString("sum(NbFoisPret)"))));
                listLivre.getData().add(series);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    //SituationLivreQuery End
    
    
    //SituationGeneralLivreQuery Begin
    public ObservableList<SituationLivreGS> getAllSituationGeneralLivre(){
        ObservableList<SituationLivreGS> listLivre = FXCollections.observableArrayList();
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by Designation";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                SituationLivreGS situation = new SituationLivreGS();
                situation.setDesignation(rs.getString("Designation"));
                situation.setNbFoisPret(rs.getString("sum(NbFoisPret)"));
                listLivre.add(situation);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public ObservableList<PieChart.Data> DiagrammeCirculaireLivreGeneralSituation(){
        ObservableList<PieChart.Data> listLivre = FXCollections.observableArrayList();
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by Designation";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                PieChart.Data data = new PieChart.Data(rs.getString("Designation"), new Integer(rs.getString("sum(NbFoisPret)")));
                listLivre.add(data);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    
    public BarChart<String, Number> DiagrammeBattonLivreGeneralSituation(CategoryAxis xAxis, NumberAxis yAxis){
        BarChart<String, Number> listLivre = new BarChart<>(xAxis,yAxis);
        String sql = "select Designation,sum(NbFoisPret) from livre,pret,lecteur where numLivre = livreNum and numLecteur = LecteurNum group by Designation";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            while(rs.next()){
                XYChart.Series series = new XYChart.Series();
                series.setName(rs.getString("Designation"));
                series.getData().add(new XYChart.Data(rs.getString("Designation"),new Integer(rs.getString("sum(NbFoisPret)"))));
                listLivre.getData().add(series);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
      return listLivre;
    }
    //SituationGeneralLivreQuery End
    
    
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
