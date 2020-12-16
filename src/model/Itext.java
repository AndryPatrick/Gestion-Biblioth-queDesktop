/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author PA PC
 */
public class Itext {
   
    private static final String FILE= "D:/testpdf.pdf";
    
    public static void main(String[] args){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            Paragraph p1 = new Paragraph ("akory ly venot");
            document.add(p1);
            document.close();
        }
        catch (FileNotFoundException | DocumentException e)  {
        }
    }
}  
