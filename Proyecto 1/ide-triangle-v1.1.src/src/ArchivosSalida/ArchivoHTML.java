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
    private String fileName;
    
    public ArchivoHTML(String fileName){
        File htmlFile = new File(fileName);
        crearHTML(htmlFile, 1);
        
    }
    
    public void crearHTML(File htmlFile, int flag){
        
        if (flag == 1){
            try  {
            
            writerHTML = new FileWriter(htmlFile);
            writerHTML.write("<!DOCTYPE html>");
            writerHTML.write("\n");
            writerHTML.write("<html>");
            writerHTML.write("\n");

            writerHTML.write("<p style=\"font-family: DejaVu Sans, monospace;\">");
            
            writerHTML.close();
            } 
            catch (IOException e) {
//            System.err.println("Error al crear HTML del programa fuente " + e.getMessage());
            e.printStackTrace();
                }
        }
        else{
            try  {
            writerHTML = new FileWriter(htmlFile);
            writerHTML.write("</p>" + "\n" +"</html>");
            writerHTML.close();
            } 
            catch (IOException e) {
            System.err.println("Error al cerrar el HTML del programa fuente " + e.getMessage());
            e.printStackTrace();
        }
        }
        
    }
    public void escribir(String texto){
        try {
//            writerHTML = new FileWriter(fileName);
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
