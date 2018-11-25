package svgger.commands;

public class TurnRight extends Command {
    /** Turns the pen right. */
    @Override
    public void run(Interpreter interpreter) {
        switch (interpreter.getCurrentDirection()) {
            case UP:
                interpreter.setDirection(Interpreter.Direction.RIGHT);
                break;
            case RIGHT:
                interpreter.setDirection(Interpreter.Direction.DOWN);
                break;
            case DOWN:
                interpreter.setDirection(Interpreter.Direction.LEFT);
                break;
            case LEFT:
                interpreter.setDirection(Interpreter.Direction.UP);
                break;
        }
    }
}
