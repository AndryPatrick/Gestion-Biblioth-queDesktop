/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;



/**
 *
 * @author Thinot
 */
public class LivreGS {
    
    private String numLivre;
    private String Designation;
    private String Titre;
    private String Auteur;
    private String Date_Edition;
    private String Disponible;
    
    public String getNumLivre(){
        return numLivre;
    }
    
    public void setNumLivre(String numLivre){
        this.numLivre = numLivre;
    }
    
    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }
    
    public String getAuteur(){
        return Auteur;
    }
    
    public void setAuteur(String Auteur){
        this.Auteur = Auteur;
    }
    
    public String getDateEdition(){
        return Date_Edition;
    }
    
    public void setDateEdition(String Date_Edition){
        this.Date_Edition = Date_Edition;
    }
    
    public String getDisponible(){
        return Disponible;
    }
    
    public void setDisponible(String Disponible){
        this.Disponible = Disponible;
    }
    
    public LivreGS(String numLivre, String Designation,String Titre, String Auteur, String Date_Edition, String Disponible) {
        this.numLivre = numLivre;
        this.Designation = Designation;
        this.Titre = Titre;
        this.Auteur = Auteur;
        this.Date_Edition = Date_Edition;
        this.Disponible = Disponible;
    }
    
    public LivreGS(String numLivre){
        this.numLivre = numLivre;
    }
    
    public LivreGS(){}
}
