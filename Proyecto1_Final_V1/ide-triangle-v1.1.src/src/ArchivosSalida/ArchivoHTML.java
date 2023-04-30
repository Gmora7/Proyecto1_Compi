/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArchivosSalida;
import Triangle.SyntacticAnalyzer.Token;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Maria Jose
 */

//Comentario prueba
public class ArchivoHTML {
    FileWriter writerHTML;
    String nombreArchivo;
    
    public ArchivoHTML(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
//    public ArchivoHTML(String fileName){
//        System.out.println("jejej " +fileName);
//        File htmlFile = new File("Pruebas"+File.separator,sourceName.concat(".html"));
//        try{
//            writerHTML = new FileWriter(htmFile)
//            System.out.println('entro try');
//            writerHTML.write("hola");
//            System.out.println('entro escribi[o');
//            writerHTML.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    
    public void escribir(String content){
        try (FileWriter writerHTML = new FileWriter(nombreArchivo, true)){
            
            writerHTML.write(content);
            writerHTML.close();
        } catch (IOException e) {
           System.out.println("Error al agregar nueva linea al HTML");
        }
    }
//    
    public void HTML(Token currentToken){
        switch(currentToken.kind){
            case Token.ARRAY:
            case Token.CONST:
            case Token.DO:
            case Token.ELSE:
            case Token.END:
            case Token.FOR:
            case Token.FROM:
            case Token.FUNC:
            case Token.IF:
            case Token.IN:

            case Token.LET:

            case Token.OF:
            case Token.PROC:
            case Token.REC:
            case Token.RECORD:
            case Token.REPEAT:

            case Token.SELECT:
            case Token.THEN:
            case Token.TO:
            case Token.TYPE:
            case Token.UNTIL:
            case Token.VAR:
            case Token.WHEN:
            case Token.WHILE:
            {
                escribir(" <font style='padding-left:1em'><b><tt> "+ currentToken.spelling +" </tt></b></font> ");
                break;
            }
            
            case Token.INTLITERAL:
            case Token.CHARLITERAL:
            {
                escribir(" <font style='padding-left:1em' color=\"#5050DB\"><tt> "+ currentToken.spelling +" </tt></font> ");
                break;
            }
            
            case Token.IDENTIFIER:
            case Token.OPERATOR:
            case Token.DOT:    
            case Token.COLON:    
            case Token.SEMICOLON:    
            case Token.COMMA:    
            case Token.BECOMES:    
            case Token.IS:    
            case Token.BAR:    
            case Token.LPAREN:    
            case Token.RPAREN:    
            case Token.LBRACKET:    
            case Token.RBRACKET:    
            case Token.LCURLY:    
            case Token.RCURLY:    
            {
                escribir(" <font style='padding-left:1em' color:'#000000'><tt> "+ currentToken.spelling +" </tt></font> ");
                break;
            }
           case Token.EOT: {
                break;
            }
            default:
                break;
        }
    }
}
