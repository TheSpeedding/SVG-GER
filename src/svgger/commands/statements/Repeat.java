package svgger.commands.statements;


import svgger.commands.Program;
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
    public void run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
        int val = expr.getValue(varTable);
        for (int i = 0; i < val; ++i) {
            statement.run(program, varTable);
        }
    }
}
