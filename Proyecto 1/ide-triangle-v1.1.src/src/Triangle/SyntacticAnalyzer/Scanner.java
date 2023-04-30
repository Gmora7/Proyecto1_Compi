/*
 * @(#)Scanner.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;
import ArchivosSalida.ArchivoHTML;
import java.io.IOException;


public final class Scanner {

  private SourceFile sourceFile;
  private boolean debug;

  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;
  private ArchivoHTML archivoHTML;
  private int htmlCreado;

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////
  public Scanner(SourceFile source) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    this.htmlCreado = 0;
    debug = false;
  }
  
  public Scanner(SourceFile source, ArchivoHTML archivoHTML) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    debug = false;
    this.htmlCreado = 1;
    this.archivoHTML = archivoHTML;
  }
  public void completarHTML(ArchivoHTML archivoHTML){
    this.htmlCreado = 1;
    this.archivoHTML = archivoHTML;
    Token token;
    do {
      token = this.scan();
    }while(token.kind != Token.EOT);
    archivoHTML.escribir("</p>" + "\n" +"</html>");
   
    }
  
  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.

  private void takeIt() {
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();
  }

  // scanSeparator skips a single separator.

  private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT))
          takeIt();
        if (currentChar == SourceFile.EOL)
          takeIt();
      }
      break;

    case ' ': case '\n': case '\r': case '\t':
      takeIt();
      break;
    }
  }

  private int scanToken(){
    String Otro;
    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      return Token.IDENTIFIER;

    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
      return Token.INTLITERAL;

    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      String Operadores = String.valueOf(currentChar);
      while (isOperator(currentChar))
        Operadores += currentChar;  
        takeIt();
      if(this.htmlCreado == 1){
        archivoHTML.defaultHTML(Operadores);
      }

      return Token.OPERATOR;

    case '\'':
      takeIt();
      String Char = String.valueOf(currentChar);
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        if(this.htmlCreado == 1){
            archivoHTML.literalesHTML(Char);
        }
        return Token.CHARLITERAL;
      } else
        return Token.ERROR;

    case '.':
      Otro = String.valueOf(currentChar);
      takeIt();
      if (currentChar == '.') {
        takeIt();
        if(this.htmlCreado == 1){
            archivoHTML.otrosHTML(Otro);
        } 
        return Token.DOTDOT;
      } else
        return Token.DOT;

    case ':':
      Otro = String.valueOf(currentChar);  
      takeIt();
      if (currentChar == '=') {
        takeIt();
        if(this.htmlCreado == 1){
            archivoHTML.otrosHTML(Otro);
        }
        return Token.BECOMES;
      } else
        return Token.COLON;

    case ';':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      takeIt();
      return Token.SEMICOLON;

    case ',':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      takeIt();
      return Token.COMMA;

    case '~':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      takeIt();
      return Token.IS;
      
      //Se agregó BAR 
    case '|':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      } 
      takeIt();
      return Token.BAR;  
      
      //Se agregó DOLLAR
    case '$':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }  
      takeIt();
      return Token.DOLLAR; 
      
    case '(':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      takeIt();
      return Token.LPAREN;

    case ')':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      } 
      takeIt();
      return Token.RPAREN;

    case '[':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      } 
      takeIt();
      return Token.LBRACKET;

    case ']':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      } 
      takeIt();
      return Token.RBRACKET;

    case '{':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      takeIt();
      return Token.LCURLY;

    case '}':
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      } 
      takeIt();
      return Token.RCURLY;

    case SourceFile.EOT:
      return Token.EOT;

    default:
      takeIt();
      Otro = String.valueOf(currentChar);
      if(this.htmlCreado == 1){
        archivoHTML.otrosHTML(Otro);
      }
      return Token.ERROR;
    }
  }

  public Token scan (){
    Token tok;
    SourcePosition pos;
    int kind;

    currentlyScanningToken = false;
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();

    kind = scanToken();

    pos.finish = sourceFile.getCurrentLine();
    tok = new Token(kind, currentSpelling.toString(), pos);
    boolean wasIdentifier = (kind == Token.IDENTIFIER);
    tok = new Token(kind, currentSpelling.toString(), pos);
    if(this.htmlCreado == 1){
        if(wasIdentifier && tok.kind != Token.IDENTIFIER)
            this.archivoHTML.palabrasReservadasHTML(tok.spelling);
        else if (wasIdentifier){
            archivoHTML.otrosHTML(tok.spelling);

    }
      }

    if (debug)
      System.out.println(tok);
    return tok;
  }

}
