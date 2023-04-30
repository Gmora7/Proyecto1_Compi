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

    
    public RepeatCommand (WhileCommand While, SourcePosition thePosition) {
    super (thePosition);
    WhileC = While;
  }


     public Object visit(Visitor v, Object o) {
    return v.visitRepeatCommand(this, o);
  }
     
  public WhileCommand WhileC;

}
