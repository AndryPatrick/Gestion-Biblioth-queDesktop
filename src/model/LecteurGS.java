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
public class LecteurGS {
    
    private String numLecteur;
    private String nom;
   
    
    public String getNumero(){
        return numLecteur;
    }
    
    public void setNumero(String numLecteur){
        this.numLecteur = numLecteur;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public LecteurGS(String numLecteur, String nom){
        this.numLecteur = numLecteur;
        this.nom = nom;
    }
    
    public LecteurGS(String numLecteur){
        this.numLecteur = numLecteur;
    }
    
    public LecteurGS(){}
}
