package svgger.commands;

public class TurnLeft extends Command {
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
