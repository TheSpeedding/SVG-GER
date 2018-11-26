package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;

import java.util.HashMap;

/** Standard function that turns the pen left. */
public class TurnLeft extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
            switch (interpreter.getCurrentDirection()) {
                case UP:
                    interpreter.setDirection(Interpreter.Direction.LEFT);
                    break;
                case RIGHT:
                    interpreter.setDirection(Interpreter.Direction.UP);
                    break;
                case DOWN:
                    interpreter.setDirection(Interpreter.Direction.RIGHT);
                    break;
                case LEFT:
                    interpreter.setDirection(Interpreter.Direction.DOWN);
                    break;
            }
        }
    }

    public TurnLeft() {
        super("TURN_LEFT");
        addCommand(new HelperStatement());
    }
}