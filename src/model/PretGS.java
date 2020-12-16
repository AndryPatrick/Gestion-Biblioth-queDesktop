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
public class PretGS {
    
    private String numPret;
    private String LecteurNum;
    private String LivreNum;
    private String DatePret;
    private String DateRetour;
    
    public String getNumPret() {
        return numPret;
    }

    public void setNumPret(String numPret) {
        this.numPret = numPret;
    }

    public String getLecteurNum() {
        return LecteurNum;
    }

    public void setLecteurNum(String LecteurNum) {
        this.LecteurNum = LecteurNum;
    }

    public String getLivreNum() {
        return LivreNum;
    }

    public void setLivreNum(String LivreNum) {
        this.LivreNum = LivreNum;
    }

    public String getDatePret() {
        return DatePret;
    }

    public void setDatePret(String DatePret) {
        this.DatePret = DatePret;
    }

    public String getDateRetour() {
        return DateRetour;
    }

    public void setDateRetour(String DateRetour) {
        this.DateRetour = DateRetour;
    }

    public PretGS(String numPret, String LecteurNum, String LivreNum, String DatePret, String DateRetour) {
        this.numPret = numPret;
        this.LecteurNum = LecteurNum;
        this.LivreNum = LivreNum;
        this.DatePret = DatePret;
        this.DateRetour = DateRetour;
    }

   public PretGS(String numPret){
       this.numPret = numPret;
   }
    
   public PretGS(){}
}
