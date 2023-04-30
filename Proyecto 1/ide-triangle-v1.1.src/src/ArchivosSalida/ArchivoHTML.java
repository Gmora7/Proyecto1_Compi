/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArchivosSalida;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Scanner;//import Triangle.SyntacticAnalyzer.Token;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Maria Jose
 */
public class ArchivoHTML {
    private FileWriter writerHTML;

    public  ArchivoHTML(String fileName){
        
        File htmlFile = new File("Pruebas",fileName);
        try  {
            writerHTML = new FileWriter(htmlFile,true);
            System.out.println("Archivo html");  
            escribir("<!DOCTYPE html>\n <html>\n<p style=\"font-family: DejaVu Sans, monospace;\">\n");
        } 
        catch (IOException e) {
//            System.err.println("Error al crear HTML del programa fuente " + e.getMessage());
            e.printStackTrace();
            }
        }
        
    
    public void escribir(String texto){
        try {
//          writerHTML = new FileWriter(fileName);
            writerHTML.write(texto);
            writerHTML.close();
    } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al incluir texto en el HTML " + e.getMessage());
            
        }
    }
    
    public void defaultHTML(String texto){
        escribir(texto);
    }
    public void palabrasReservadasHTML(String PalabraReservada){
        String textoHTML = " <font style='padding-left:1em'><b><tt> "+PalabraReservada+" </tt></b></font> ";
        escribir(textoHTML);
    }
    public void literalesHTML(String Literales) {
        String textoHTML = " <font style='padding-left:1em' color=\"#5050DB\"><tt> "+ Literales +" </tt></font>\n ";
        escribir(textoHTML);
    }
           
    public void comentariosHTML(String comentario){
        String textoHTML = "<span style=\"color:green\">" + comentario + "</span><br>\n";
        escribir(textoHTML);
    }
    public void otrosHTML(String otros){
        String textoHTML = " <font style='padding-left:1em' color:'#000000'><tt> "+ otros +" </tt></font>\n";
        escribir(textoHTML);
    }
    
}
