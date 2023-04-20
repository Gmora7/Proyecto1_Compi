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
public class CaseCommand extends Command{
    public CaseLiterals caseLiterals;
    public Command command;

    public CaseCommand(CaseLiterals caseLiterals, Command command, SourcePosition position) {
        super(position);
        this.caseLiterals = caseLiterals;
        this.command = command;
    }

    public CaseCommand(SourcePosition position) {
        super(position);
        this.caseLiterals = null;
        this.command = null;
    }

    public Object visit(Visitor visitor, Object arg) {
        return visitor.visitCaseCommand(this, arg);
    }

    public CaseLiterals getCaseLiterals() {
        return caseLiterals;
    }

    public Command getCommand() {
        return command;
    }
    
}
