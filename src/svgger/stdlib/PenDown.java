package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;

import java.util.HashMap;

/** Standard function that sets the pen down. */
public class PenDown extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
            interpreter.setPenDown();
        }
    }

    public PenDown() {
        super("PEN_DOWN");
        addCommand(new HelperStatement());
    }
}