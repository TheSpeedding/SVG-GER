package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.util.SvggerList;

import java.util.HashMap;

/** Standard function that sets the width for the lines. */
public class SetWidth extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            var width = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.

            program.getStyle().setWidth(width);

            return true;
        }
    }

    public SetWidth() {
        super("SET_WIDTH", new SvggerList<>(new VariableIdentifier("n")));
        addCommand(new HelperStatement());
    }
}