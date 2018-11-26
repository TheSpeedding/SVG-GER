package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.statements.Statement;

/** Standard function that sets the pen down. */
public class PenDown extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter) {
            interpreter.setPenDown();
        }
    }

    public PenDown() {
        super("PEN_DOWN");
        addCommand(new HelperStatement());
    }
}
