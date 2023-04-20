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
public class MultipleCase extends CaseCommand{
    private final CaseCommand caseCommand1;
    private final CaseCommand caseCommand2;

    public MultipleCase(CaseCommand caseCommand1, CaseCommand caseCommand2, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.caseCommand1 = caseCommand1;
        this.caseCommand2 = caseCommand2;
    }

    public MultipleCase(CaseCommand caseCommand, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.caseCommand1 = caseCommand;
        this.caseCommand2 = null;
    }

    public Object visit(Visitor visitor, Object object) {
        return visitor.visitMultipleCase(this, object);
    }

    public CaseCommand getCaseCommand1() {
        return caseCommand1;
    }

    public CaseCommand getCaseCommand2() {
        return caseCommand2;
    }
    
}
