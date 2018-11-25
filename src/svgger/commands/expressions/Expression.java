package svgger.commands.expressions;

import java.util.HashMap;

/** Base class for expression, i.e. variables, numbers and complex expressions. */
public abstract class Expression {
    /**
     * Calculates the result of the expression.
     * @param varTable Reference to the table with variables in given context (program or function).
     * @return Result of the expression.
     */
    public abstract int getValue(HashMap<VariableIdentifier, Integer> varTable);
}
