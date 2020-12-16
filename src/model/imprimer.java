/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.ObservableList;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author PA PC
 */
public class imprimer {
    public  static void pdfLecteur()  {
       Double last=((Math.random() * 100) - 50.0);
       String FILE = "listeLecteur"+last+".pdf";
     
      LecteurQuery queryLecteur=new LecteurQuery();
      ObservableList<LecteurGS> listLecteur=queryLecteur.getAllLecteur();
      
    
              try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph(" "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("LISTE DES LECTEURS", FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));
        document.add(new Paragraph(new java.util.Date().toString()));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));

        //        AJOUT TITRE
        PdfPTable tablefact=new PdfPTable(2);
        tablefact.setWidthPercentage(100);

        PdfPCell cell1=new PdfPCell(new Paragraph("NUMERO LECTEUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell2=new PdfPCell(new Paragraph("NOM LECTEUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
//        PdfPCell cell3=new PdfPCell(new Paragraph("PRENOM",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell4=new PdfPCell(new Paragraph("ADRESSE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell5=new PdfPCell(new Paragraph("DATE_NAISSANCE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell6=new PdfPCell(new Paragraph("SEXE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell7=new PdfPCell(new Paragraph("CLASSE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell8=new PdfPCell(new Paragraph("ANNEE SCO",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
        
        cell1.setColspan(1);
        cell2.setColspan(1);
//        
//        cell3.setColspan(1);
//        cell4.setColspan(1);
//        cell5.setColspan(1);
//        cell6.setColspan(1);
//        cell7.setColspan(1);
//        cell8.setColspan(1);

        cell1.setRowspan(1);
        cell2.setRowspan(1);
        
//        cell3.setRowspan(1);
//        cell4.setRowspan(1);
//        cell5.setRowspan(1);
//        cell6.setRowspan(1);
//        cell7.setRowspan(1);
//         cell8.setColspan(1);
        
        tablefact.addCell(cell1);
        tablefact.addCell(cell2);
//        tablefact.addCell(cell3);
//        tablefact.addCell(cell4);
//        tablefact.addCell(cell5);
//        tablefact.addCell(cell6);
//        tablefact.addCell(cell7);
//        tablefact.addCell(cell8);
        
        tablefact.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(tablefact);

        for (LecteurGS e : listLecteur) {
        	PdfPTable tab1=new PdfPTable(2);
            tab1.setWidthPercentage(100);

            PdfPCell cell27=new PdfPCell(new Paragraph(e.getNumero()));
            cell27.setColspan(1);
            cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell27.setBackgroundColor(BaseColor.GRAY);
            cell27.setBorderColor(BaseColor.CYAN);
            tab1.addCell(cell27);

            PdfPCell cell28=new PdfPCell(new Paragraph(e.getNom()));
            cell28.setColspan(1);
            cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell28.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell28.setBorderColor(BaseColor.BLUE);
             tab1.addCell(cell28);
            
//            PdfPCell cell29=new PdfPCell(new Paragraph(e.getPrenom()));
//            cell29.setColspan(1);
//            cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
//            // cell29.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell29);
//             PdfPCell cell30=new PdfPCell(new Paragraph(e.getAdresse()));
//            cell30.setColspan(1);
//            cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell30.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell30);
//            PdfPCell cell31=new PdfPCell(new Paragraph(e.getDate_naiss()));
//            cell31.setColspan(1);
//            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
//            // cell31.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell31);
//            PdfPCell cell32=new PdfPCell(new Paragraph(e.getSexe()));
//            cell32.setColspan(1);
//            cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
//            // cell32.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell32);
//             PdfPCell cell33=new PdfPCell(new Paragraph(e.getAnnee()));
//            cell33.setColspan(1);
//            cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell33);
//            PdfPCell cell34=new PdfPCell(new Paragraph(e.getAnnee_sco()));
//            cell34.setColspan(1);
//            cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell34);
            
            document.add(tab1);


        }

            document.add(new Paragraph("  "));
            document.add(new Paragraph("Liste des lecteurs"+ "      ", FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));

        document.close();

        Desktop.getDesktop().open(new File("listeLecteur"+last+".pdf"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
      public static void pdfLivre(){
          Double last=((Math.random() * 100) - 50.0);
       String FILE = "listeLivre"+last+".pdf";
       
        LivreQuery queryLecteur=new LivreQuery();
      ObservableList<LivreGS> listLivre=queryLecteur.getAllLivre();
      
    
              try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph(" "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("LISTE DES LECTEURS", FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));
        document.add(new Paragraph(new java.util.Date().toString()));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));

        //        AJOUT TITRE
        PdfPTable tablefact=new PdfPTable(6);
        tablefact.setWidthPercentage(100);

        PdfPCell cell1=new PdfPCell(new Paragraph("NUMERO LIVRE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell2=new PdfPCell(new Paragraph("DESIGNATION",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell3=new PdfPCell(new Paragraph("TITRE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell4=new PdfPCell(new Paragraph("AUTEUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell5=new PdfPCell(new Paragraph("DATE_EDITION",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell6=new PdfPCell(new Paragraph("DESIGNATION",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
//        PdfPCell cell7=new PdfPCell(new Paragraph("CLASSE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell8=new PdfPCell(new Paragraph("ANNEE SCO",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
        
        cell1.setColspan(1);
        cell2.setColspan(1);            
        cell3.setColspan(1);
        cell4.setColspan(1);
        cell5.setColspan(1);
       cell6.setColspan(1);
//        cell7.setColspan(1);
//        cell8.setColspan(1);

        cell1.setRowspan(1);
        cell2.setRowspan(1);
        cell3.setRowspan(1);
        cell4.setRowspan(1);
        cell5.setRowspan(1);
        cell6.setRowspan(1);
//        cell7.setRowspan(1);
//         cell8.setColspan(1);
        
        tablefact.addCell(cell1);
        tablefact.addCell(cell2);
        tablefact.addCell(cell3);
        tablefact.addCell(cell4);
        tablefact.addCell(cell5);
        tablefact.addCell(cell6);
//        tablefact.addCell(cell7);
//        tablefact.addCell(cell8);
        
        tablefact.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(tablefact);

        for (LivreGS e : listLivre) {
        	PdfPTable tab1=new PdfPTable(6);
            tab1.setWidthPercentage(100);

            PdfPCell cell27=new PdfPCell(new Paragraph(e.getNumLivre()));
            cell27.setColspan(1);
            cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell27.setBackgroundColor(BaseColor.GRAY);
            cell27.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell27);

            PdfPCell cell28=new PdfPCell(new Paragraph(e.getDesignation()));
            cell28.setColspan(1);
            cell28.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell28.setBorderColor(BaseColor.YELLOW);
             tab1.addCell(cell28);
            
            PdfPCell cell29=new PdfPCell(new Paragraph(e.getTitre()));
            cell29.setColspan(1);
            cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell29.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell29.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell29);

            PdfPCell cell30=new PdfPCell(new Paragraph(e.getAuteur()));
            cell30.setColspan(1);
            cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell30.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell30.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell30);
            
            PdfPCell cell31=new PdfPCell(new Paragraph(e.getDateEdition()));
            cell31.setColspan(1);
            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell31.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell31.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell31);
            
            PdfPCell cell32=new PdfPCell(new Paragraph(e.getDisponible()));
            cell32.setColspan(1);
            cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell32.setBackgroundColor(BaseColor.GRAY);
            cell32.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell32);

//             PdfPCell cell33=new PdfPCell(new Paragraph(e.getAnnee()));
//            cell33.setColspan(1);
//            cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell33);
//            PdfPCell cell34=new PdfPCell(new Paragraph(e.getAnnee_sco()));
//            cell34.setColspan(1);
//            cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell34);
            
            document.add(tab1);


        }

            document.add(new Paragraph("  "));
            document.add(new Paragraph("Liste des livres"
                    + "      ", FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));

        document.close();

        Desktop.getDesktop().open(new File("listeLivre"+last+".pdf"));

        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      
      
              
          
      public static void pdfPret(){
          Double last=((Math.random() * 100) - 50.0);
       String FILE = "listeprets"+last+".pdf";
       
        PretQuery queryLecteur=new PretQuery();
      ObservableList<PretGS> listPret=queryLecteur.getAllPret();
      
    
              try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph(" "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("LISTE DES PRETS", FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));
        document.add(new Paragraph(new java.util.Date().toString()));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));

        //        AJOUT TITRE
        PdfPTable tablefact=new PdfPTable(5);
        tablefact.setWidthPercentage(100);

        PdfPCell cell1=new PdfPCell(new Paragraph("NUMERO PRET",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell2=new PdfPCell(new Paragraph("NUMERO LECTEUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell3=new PdfPCell(new Paragraph("NUMERO LIVRE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell4=new PdfPCell(new Paragraph("DATE PRET",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell5=new PdfPCell(new Paragraph("DATE RETOUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
 //       PdfPCell cell6=new PdfPCell(new Paragraph("DESIGNATION",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
//        PdfPCell cell7=new PdfPCell(new Paragraph("CLASSE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
//        PdfPCell cell8=new PdfPCell(new Paragraph("ANNEE SCO",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
        
        cell1.setColspan(1);
        cell2.setColspan(1);            
        cell3.setColspan(1);
        cell4.setColspan(1);
        cell5.setColspan(1);
 //      cell6.setColspan(1);
//        cell7.setColspan(1);
//        cell8.setColspan(1);

        cell1.setRowspan(1);
        cell2.setRowspan(1);
        cell3.setRowspan(1);
        cell4.setRowspan(1);
        cell5.setRowspan(1);
//        cell6.setRowspan(1);
//        cell7.setRowspan(1);
//         cell8.setColspan(1);
        
        tablefact.addCell(cell1);
        tablefact.addCell(cell2);
        tablefact.addCell(cell3);
        tablefact.addCell(cell4);
        tablefact.addCell(cell5);
 //       tablefact.addCell(cell6);
//        tablefact.addCell(cell7);
//        tablefact.addCell(cell8);
        
        tablefact.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(tablefact);

        for (PretGS e : listPret) {
        	PdfPTable tab1=new PdfPTable(5);
            tab1.setWidthPercentage(100);

            PdfPCell cell27=new PdfPCell(new Paragraph(e.getNumPret()));
            cell27.setColspan(1);
            cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell27.setBackgroundColor(BaseColor.GRAY);
            cell27.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell27);

            PdfPCell cell28=new PdfPCell(new Paragraph(e.getLecteurNum()));
            cell28.setColspan(1);
            cell28.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell28.setBorderColor(BaseColor.YELLOW);
             tab1.addCell(cell28);
            
            PdfPCell cell29=new PdfPCell(new Paragraph(e.getLivreNum()));
            cell29.setColspan(1);
            cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell29.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell29.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell29);

            PdfPCell cell30=new PdfPCell(new Paragraph(e.getDatePret()));
            cell30.setColspan(1);
            cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell30.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell30.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell30);
            
            PdfPCell cell31=new PdfPCell(new Paragraph(e.getDateRetour()));
            cell31.setColspan(1);
            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell31.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell31.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell31);
            
         //PdfPCell cell32=new PdfPCell(new Paragraph(e.getDisponible()));
          //  cell32.setColspan(1);
            //cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell32.setBackgroundColor(BaseColor.GRAY);
            //cell32.setBorderColor(BaseColor.YELLOW);
            //tab1.addCell(cell32);

//             PdfPCell cell33=new PdfPCell(new Paragraph(e.getAnnee()));
//            cell33.setColspan(1);
//            cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell33);
//            PdfPCell cell34=new PdfPCell(new Paragraph(e.getAnnee_sco()));
//            cell34.setColspan(1);
//            cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //cell33.setBackgroundColor(BaseColor.GRAY);
//            tab1.addCell(cell34);
            
            document.add(tab1);


        }

            document.add(new Paragraph("  "));
            document.add(new Paragraph("Liste des prets"
                    + "      ", FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));

        document.close();

        Desktop.getDesktop().open(new File("listeprets"+last+".pdf"));

        } catch (Exception e) {
            e.printStackTrace();
        }
          
      }
      
      
      
      public static void pdfOuvrage(){
          Double last=((Math.random() * 100) - 50.0);
       String FILE = "listeouvrage"+last+".pdf";
       
      OuvrageQuery queryLecteur=new OuvrageQuery();
      ObservableList<OuvrageGS> listOuvrage=queryLecteur.getAllOuvrage();
      
    
              try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph(" "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("LISTE DES OUVRAGES", FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));
        document.add(new Paragraph(new java.util.Date().toString()));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));

        //        AJOUT TITRE
        PdfPTable tablefact=new PdfPTable(8);
        tablefact.setWidthPercentage(100);

        PdfPCell cell1=new PdfPCell(new Paragraph("NUMERO PRET",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell2=new PdfPCell(new Paragraph("NUMERO LECTEUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell3=new PdfPCell(new Paragraph("NUMERO LIVRE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell4=new PdfPCell(new Paragraph("DATE PRET",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell5=new PdfPCell(new Paragraph("DATE RETOUR",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell6=new PdfPCell(new Paragraph("DESIGNATION",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLUE)));
        PdfPCell cell7=new PdfPCell(new Paragraph("CLASSE",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
        PdfPCell cell8=new PdfPCell(new Paragraph("ANNEE SCO",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK)));
        
        cell1.setColspan(1);
        cell2.setColspan(1);            
        cell3.setColspan(1);
        cell4.setColspan(1);
        cell5.setColspan(1);
        cell6.setColspan(1);
        cell7.setColspan(1);
        cell8.setColspan(1);

        cell1.setRowspan(1);
        cell2.setRowspan(1);
        cell3.setRowspan(1);
        cell4.setRowspan(1);
        cell5.setRowspan(1);
        cell6.setRowspan(1);
        cell7.setRowspan(1);
        cell8.setColspan(1);
        
        tablefact.addCell(cell1);
        tablefact.addCell(cell2);
        tablefact.addCell(cell3);
        tablefact.addCell(cell4);
        tablefact.addCell(cell5);
        tablefact.addCell(cell6);
        tablefact.addCell(cell7);
        tablefact.addCell(cell8);
        
        tablefact.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(tablefact);

        for (OuvrageGS e : listOuvrage) {
        	PdfPTable tab1=new PdfPTable(8);
            tab1.setWidthPercentage(100);

            PdfPCell cell27=new PdfPCell(new Paragraph(e.getNumLecteur()));
            cell27.setColspan(1);
            cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell27.setBackgroundColor(BaseColor.GRAY);
            cell27.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell27);

            PdfPCell cell28=new PdfPCell(new Paragraph(e.getNom()));
            cell28.setColspan(1);
            cell28.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell28.setBorderColor(BaseColor.YELLOW);
             tab1.addCell(cell28);
            
            PdfPCell cell29=new PdfPCell(new Paragraph(e.getDesignation()));
            cell29.setColspan(1);
            cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell29.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell29.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell29);

            PdfPCell cell30=new PdfPCell(new Paragraph(e.getTitre()));
            cell30.setColspan(1);
            cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell30.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell30.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell30);
            
            PdfPCell cell31=new PdfPCell(new Paragraph(e.getAuteur()));
            cell31.setColspan(1);
            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell31.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell31.setBorderColor(BaseColor.YELLOW);
            tab1.addCell(cell31);
            
         PdfPCell cell32=new PdfPCell(new Paragraph(e.getDateEdition()));
         cell32.setColspan(1);
         cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell32.setBackgroundColor(BaseColor.GRAY);
         cell32.setBorderColor(BaseColor.YELLOW);
         tab1.addCell(cell32);

              PdfPCell cell33=new PdfPCell(new Paragraph(e.getDatePret()));
             cell33.setColspan(1);
             cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell33.setBackgroundColor(BaseColor.GRAY);
             tab1.addCell(cell33);
             
             PdfPCell cell34=new PdfPCell(new Paragraph(e.getDateRetour()));
             cell34.setColspan(1);
             cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell33.setBackgroundColor(BaseColor.GRAY);
             tab1.addCell(cell34);
            
            document.add(tab1);


        }

            document.add(new Paragraph("  "));
            document.add(new Paragraph("Liste des ouvrages"
                    + "      ", FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK)));

        document.close();

        Desktop.getDesktop().open(new File("listeouvrage"+last+".pdf"));

        } catch (Exception e) {
            e.printStackTrace();
        }
          
      }
      
}
