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
public class MultipleCaseRange extends CaseRangeCommand{
    
    private final CaseRangeCommand cAST;
    private final CaseRangeCommand cAST2;

    public MultipleCaseRange(CaseRangeCommand cAST, SourcePosition thePosition) {
        super(thePosition);
        this.cAST = cAST;
        this.cAST2 = null;
    }

    public MultipleCaseRange(MultipleCaseRange cAST, CaseRangeCommand cAST2, SourcePosition thePosition) {
        super(thePosition);
        this.cAST = cAST.getCrcmcr();
        this.cAST2 = cAST2;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitMultipleCaseRange(this, o);
    }

    public CaseRangeCommand getCrcmcr() {
        return cAST;
    }

    public CaseRangeCommand getCrcmcr2() {
        return cAST2;
    }
    
    
}
