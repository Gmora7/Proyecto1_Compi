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
public class CasesCommand extends Command{
    public SingleCase singleCase;
    public MultipleCase multipleCase;

    public CasesCommand(SingleCase singleCase, SourcePosition position) {
        super(position);
        this.singleCase = singleCase;
        this.multipleCase = null;
    }

    public CasesCommand(MultipleCase multipleCase, SourcePosition position) {
        super(position);
        this.multipleCase = multipleCase;
        this.singleCase = null;
    }

    public Object visit(Visitor visitor, Object arg) {
        return visitor.visitCasesCommand(this, arg);
    }

    public SingleCase getSingleCase() {
        return singleCase;
    }

    public MultipleCase getMultipleCase() {
        return multipleCase;
    }
    
    
}
