/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArchivosSalida;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.SyntacticAnalyzer.Token;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Maria Jose
 */
public class ArchivoHTML {
    FileWriter writerHTML;
    String fileName;
    
    public ArchivoHTML(String fileName){
        this.fileName = fileName;
    }
    
    
    public void crearHTML(String fileName)throws IOException{
        try  {
            writerHTML = new FileWriter(fileName, true);
            
            writerHTML.write("<!DOCTYPE html>");
            writerHTML.write("\n");
            writerHTML.write("<html>");
            writerHTML.write("\n");

            writerHTML.write("<p style=\"font-family: DejaVu Sans, monospace;\">");
            writerHTML.close();
    } catch (IOException e) {
            System.err.println("Error al crear HTML del programa fuente " + e.getMessage());
            throw e;
        }
    }
    public void cerrarHTML(){
        try  {
            writerHTML.write("</p>" + "\n" +"</html>");
            writerHTML.close();
    } catch (IOException e) {
            System.err.println("Error al cerrar el HTML del programa fuente " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void defaultHTML(String texto){
        try {
            writerHTML.write(texto);
            writerHTML.close();
    } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al incluir texto en el HTML " + e.getMessage());
            
        }
    }
    public void palabrasReservadasHTML(String PalabraReservada){
        try {

            writerHTML.write(" <font style='padding-left:1em'><b><tt> "+PalabraReservada+" </tt></b></font> ");
            writerHTML.close();
           
    } catch (IOException e) {
            e.printStackTrace();            
        }
        
    }
    public void literalesHTML(String Literales){
        try {

            writerHTML.write(" <font style='padding-left:1em' color=\"#5050DB\"><tt> "+ Literales +" </tt></font> ");
            writerHTML.close();
           
    } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al agregar Literales en el html " + e.getMessage());
            
        }
    }
    public void comentariosHTML(String comentario){
        try {

            writerHTML.write("<span style=\"color:green\">" + comentario + "</span><br>\n");
            writerHTML.close();
           
    } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear HTML del programa fuente " + e.getMessage());
            
        }
    }
    public void otrosHTML(String otros){
        try {
            writerHTML.write(" <font style='padding-left:1em' color:'#000000'><tt> "+ otros +" </tt></font> ");
            writerHTML.close();
           
    } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al agregar identificadores, operadores y separadores al HTML " + e.getMessage());
            
        }
    }
    
    
    public void programaFuente(Scanner scanner){
        Token token;
        do {
          token = scanner.scan();
          
        }while(token.kind != Token.EOT);
        cerrarHTML();
        }
}
