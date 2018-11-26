package svgger.commands.statements;


import svgger.commands.Interpreter;
import svgger.commands.expressions.Expression;
import svgger.commands.expressions.VariableIdentifier;

import java.util.HashMap;

/** Class representing repeat statement. */
public class Repeat extends Statement {
    private Expression expr;
    private Statement statement;

    public Repeat(Expression e, Statement s) {
        expr = e;
        statement = s;
    }

    @Override
    public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
        int val = expr.getValue(varTable);
        for (int i = 0; i < val; ++i) {
            statement.run(interpreter, varTable);
        }
    }
}
