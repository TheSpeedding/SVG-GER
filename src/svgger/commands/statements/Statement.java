package svgger.commands.statements;

import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;

import java.util.HashMap;

/** Abstract class representing a statement. */
public abstract class Statement {
    /**
     * Performs an action associated with the statement.
     * @param program Program that is the statement associated with.
     */
    public abstract void run(Program program, HashMap<VariableIdentifier, Integer> varTable);
}
