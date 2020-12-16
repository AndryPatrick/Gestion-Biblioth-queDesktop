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
public class OuvrageGS {
    
    private String numLecteur;
    private String nom;
    private String Designation;
    private String Titre;
    private String Auteur;
    private String DateEdition;
    private String DatePret;
    private String DateRetour;
    private String Amende;

    public String getAmende() {
        return Amende;
    }

    public void setAmende(String Amende) {
        this.Amende = Amende;
    }

    public String getDateRetour() {
        return DateRetour;
    }

    public void setDateRetour(String DateRetour) {
        this.DateRetour = DateRetour;
    }
    
    public String getNumLecteur() {
        return numLecteur;
    }

    public void setNumLecteur(String numLecteur) {
        this.numLecteur = numLecteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }

    public String getDateEdition() {
        return DateEdition;
    }

    public void setDateEdition(String DateEdition) {
        this.DateEdition = DateEdition;
    }
    
    public String getDatePret() {
        return DatePret;
    }

    public void setDatePret(String DatePret) {
        this.DatePret = DatePret;
    }
    
    public OuvrageGS(String DateEdition, String DatePret) {
        this.DateEdition = DateEdition;
        this.DatePret = DatePret;
    }
    
    public OuvrageGS(){}
}
