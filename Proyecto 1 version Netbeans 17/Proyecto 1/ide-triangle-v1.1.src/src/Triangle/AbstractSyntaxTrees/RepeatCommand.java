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
    
    public RepeatCommand (WhileCommand WhileVar, SourcePosition thePosition) {
    super (thePosition);
    Identifier=null;
    While = WhileVar;
  }
    public RepeatCommand (Identifier ident, WhileCommand WhileVar, SourcePosition thePosition) {
    super (thePosition);
    Identifier=ident;
    While = WhileVar;
  }
    @Override
     public Object visit(Visitor v, Object o) {
    return v.visitRepeatCommand(this, o);
  }
     

}
