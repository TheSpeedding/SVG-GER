package svgger.commands.statements;

import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Class representing block of statements enclosed in brackets. */
public class Block extends Statement {
    private SvggerList<Statement> statements;

    public Block(SvggerList<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
        for (Statement s : statements) {
            s.run(interpreter, varTable);
        }
    }
}
