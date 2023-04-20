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
    public final CaseLiteralCommand caseLiteralCommand;

    public ToCommandLiteral(CaseLiteralCommand caseLiteralCommand, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.caseLiteralCommand = caseLiteralCommand;
    }

    public Object visit(Visitor visitor, Object object) {
        return visitor.visitToCommandLiteralAST(this, object);
    }

    public CaseLiteralCommand getCaseLiteralCommand() {
        return caseLiteralCommand;
    }
    }
    

