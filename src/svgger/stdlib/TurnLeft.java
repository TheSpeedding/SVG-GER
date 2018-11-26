package svgger.stdlib;

import svgger.commands.Interpreter;
import svgger.commands.statements.Statement;

public class TurnLeft extends Statement {
    /** Turns the pen left. */
    @Override
    public void run(Interpreter interpreter) {
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
