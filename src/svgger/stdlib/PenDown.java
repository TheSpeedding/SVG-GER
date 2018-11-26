package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;

import java.util.HashMap;

/** Standard function that sets the pen down. */
public class PenDown extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            program.setPenDown();
            return true;
        }
    }

    public PenDown() {
        super("PEN_DOWN");
        addCommand(new HelperStatement());
    }
}