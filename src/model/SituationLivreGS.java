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
public class SituationLivreGS {
    private String numLivre;
    private String Designation;
    private String Titre;
    private String Auteur;
    private String DateEdition;
    private String Disponible;
    private String NbFoisPret;

    public String getNumLivre() {
        return numLivre;
    }

    public void setNumLivre(String numLivre) {
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

    public String getDisponible() {
        return Disponible;
    }

    public void setDisponible(String Disponible) {
        this.Disponible = Disponible;
    }

    public String getNbFoisPret() {
        return NbFoisPret;
    }

    public void setNbFoisPret(String NbFoisPret) {
        this.NbFoisPret = NbFoisPret;
    }
    
    public SituationLivreGS(){}
}
