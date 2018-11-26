package svgger.stdlib;

import svgger.commands.Interpreter;
import svgger.commands.statements.Statement;

public class PenUp extends Statement {
    /** Sets the pen up. */
    @Override
    public void run(Interpreter interpreter) {
        interpreter.setPenUp();
    }
}
