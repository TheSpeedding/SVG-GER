package svgger.commands;

public class PenUp extends Command {
    /** Sets the pen up. */
    @Override
    public void run(Interpreter interpreter) {
        interpreter.setPenUp();
    }
}
