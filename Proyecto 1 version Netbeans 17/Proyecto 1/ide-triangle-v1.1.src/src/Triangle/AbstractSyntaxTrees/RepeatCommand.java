/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author gmora
 */
public class RepeatCommand extends Command{
    public WhileCommand While;
    public Identifier Identifier;
    
    public RepeatCommand (WhileCommand While, SourcePosition thePosition) {
    super (thePosition);
    Identifier=null;
    While = While;
  }
    public RepeatCommand (Identifier ident, WhileCommand While, SourcePosition thePosition) {
    super (thePosition);
    Identifier=ident;
    While = While;
  }

     public Object visit(Visitor v, Object o) {
    return v.visitRepeatCommand(this, o);
  }
     

}
