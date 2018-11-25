package svgger.commands;

public class PenDown extends Command {
    /** Sets the pen down. */
    @Override
    public void run(Interpreter interpreter) {
        interpreter.setPenDown();
    }
}
