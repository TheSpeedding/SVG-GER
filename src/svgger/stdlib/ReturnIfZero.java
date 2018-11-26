package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Standard function that stops execution of the caller if an argument equals zero. */
public class ReturnIfZero extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            var x = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.
            return x != 0;
        }
    }

    public ReturnIfZero() {
        super("RETURN_IF_ZERO", new SvggerList<>(new VariableIdentifier("x")));
        addCommand(new HelperStatement());
    }
}