/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author Maria Jose
 */
public class ForBecomesAST extends Command{
    public ForBecomesCommand ForBecomes;   
    public DotDCommand E;
    public DoCommand DoC;
    
    public ForBecomesAST( ForBecomesCommand ForBecomesV, DotDCommand eAST, DoCommand Dovar, SourcePosition thePosition) {
        super (thePosition);
        ForBecomes = ForBecomesV;    
        E = eAST;
        DoC = Dovar;
    }
    
    public Object visit(Visitor v, Object o) {
      return v.visitForBecomesAST(this, o);
    }


}
