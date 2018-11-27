package svgger.commands.statements;

import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Class representing block of statements enclosed in brackets. */
public class Block extends Statement {
    private SvggerList<Statement> statements;

    /**
     * Initializes an object.
     * @param statements Statements in this block.
     */
    public Block(SvggerList<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
        for (Statement s : statements) {
            if (!s.run(program, varTable))
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + System.lineSeparator());
        for (Statement s : statements) {
            sb.append(s.toString() + System.lineSeparator());
        }
        sb.append("}" + System.lineSeparator());
        return sb.toString();
    }
}
