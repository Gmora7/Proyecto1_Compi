/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author Usuario
 */
public class DotDCommand2 extends Command{
   public DotDCommand2 (CaseLiteralCommand east, SourcePosition thePosition) {
    super (thePosition);
    CLCT = east;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitDotDCommand2(this, o);
  }

  public CaseLiteralCommand CLCT;    
}
