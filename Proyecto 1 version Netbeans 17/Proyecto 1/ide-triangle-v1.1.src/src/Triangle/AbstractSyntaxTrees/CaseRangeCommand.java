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
public class CaseRangeCommand extends Command{
    
    
    public CaseRangeCommand (CaseLiteralCommand clAST, SourcePosition thePosition){
        super(thePosition);
        CLC = clAST;
        TCL = null;
    }

    public CaseRangeCommand (CaseLiteralCommand clAST, ToCommandLiteral tcAST, SourcePosition thePosition){
        super(thePosition);
        CLC = clAST;
        TCL = tcAST;
    }
    
    public CaseRangeCommand (SourcePosition thePosition){
        super(thePosition);
        CLC = null;
        TCL = null;
    }
    
    public Object visit(Visitor v, Object o){
        return v.visitCaseRangeCommand(this, o);
    }
    
    public CaseLiteralCommand CLC;
    public ToCommandLiteral TCL; 
}
