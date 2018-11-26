package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;

import java.util.HashMap;

/** Standard function that sets the pen up. */
public class PenUp extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
            interpreter.setPenUp();
        }
    }

    public PenUp() {
        super("PEN_UP");
        addCommand(new HelperStatement());
    }
}