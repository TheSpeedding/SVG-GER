package svgger.commands.statements;

import svgger.commands.Program;
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
    public void run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
        for (Statement s : statements) {
            s.run(program, varTable);
        }
    }
}
