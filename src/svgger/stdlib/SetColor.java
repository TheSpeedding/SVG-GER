package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Standard function that sets the color for the lines. */
public class SetColor extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            int r = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.
            int g = getParameterKeys().get(1).getValue(varTable); // This variable is given by the variable in the constructor below.
            int b = getParameterKeys().get(2).getValue(varTable); // This variable is given by the variable in the constructor below.

            program.getStyle().setColor(r, g, b);

            return true;
        }
    }

    public SetColor() {
        super("SET_COLOR", new SvggerList<>(new VariableIdentifier("r"), new VariableIdentifier("g"), new VariableIdentifier("b")));
        addCommand(new HelperStatement());
    }
}