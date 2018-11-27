package svgger.commands.statements;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.Expression;
import svgger.commands.expressions.VariableIdentifier;
import svgger.util.SvggerList;

import java.security.InvalidParameterException;
import java.util.HashMap;

/** Class representing function call. */
public class FunctionCall extends Statement {
    private String name;
    private SvggerList<Expression> params;

    /**
     * Initializes an object.
     * @param name Name of the function to be called.
     * @param params Parameters for the function call.
     */
    public FunctionCall(String name, SvggerList<Expression> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
        Function f = program.getFunction(name);
        if (f == null) throw new InvalidParameterException("Function with name " + name + " does not exist in current context.");
        return f.run(program, params, varTable);
    }

    @Override
    public String toString() {
        if (params.size() == 0) {
            return name + "." + System.lineSeparator();
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < params.size() - 1; ++i) {
                sb.append(params.get(i) + ", ");
            }
            sb.append(params.get(params.size() - 1));
            return name + "(" + sb.toString() + ")." + System.lineSeparator();
        }
    }
}
