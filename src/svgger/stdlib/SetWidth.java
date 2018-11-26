package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Standard function that sets the width for the lines. */
public class SetWidth extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
            var width = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.

            interpreter.getStyle().setWidth(width);
        }
    }

    public SetWidth() {
        super("SET_WIDTH", new SvggerList<>(new VariableIdentifier("n")));
        addCommand(new HelperStatement());
    }
}