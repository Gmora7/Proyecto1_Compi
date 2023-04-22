/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author celin
 */
public class ToCommandLiteral extends Command{
    
    public ToCommandLiteral(CaseLiteralCommand cAST, SourcePosition thePosition) {
        super(thePosition);
        CLC = cAST;
    }

    public Object visit(Visitor v, Object object) {
        return v.visitToCommandLiteralAST(this, object);
    }

    public CaseLiteralCommand CLC;
    
   }
    

