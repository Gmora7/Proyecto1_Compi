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
public class SingleCase extends CaseCommand{
     private final CaseCommand caseCommand;

    public SingleCase(CaseCommand caseCommand, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.caseCommand = caseCommand;
    }

    public Object visit(Visitor visitor, Object object) {
        return visitor.visitSingleCase(this, object);
    }

    public CaseCommand getCaseCommand() {
        return caseCommand;
    }
    
}
