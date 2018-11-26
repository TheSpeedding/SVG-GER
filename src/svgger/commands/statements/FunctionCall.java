package svgger.commands.statements;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.Expression;
import svgger.commands.expressions.VariableIdentifier;
import svgger.util.SvggerList;

import java.security.InvalidParameterException;
import java.util.HashMap;

/** Class representing function call. */
public class FunctionCall extends Statement {
    private String name;
    private SvggerList<Expression> params;

    public FunctionCall(String name, SvggerList<Expression> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
        Function f = interpreter.getFunction(name);
        if (f == null) throw new InvalidParameterException("Function with name " + name + " does not exist in current context.");
        f.run(interpreter, params, varTable);
    }
}
