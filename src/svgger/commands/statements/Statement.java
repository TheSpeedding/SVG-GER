package svgger.commands.statements;

import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;

import java.util.HashMap;

/** Abstract class representing a statement. */
public abstract class Statement {
    /**
     * Performs an action associated with the statement.
     * @param interpreter Program that is the statement associated with.
     */
    public abstract void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable);
}
