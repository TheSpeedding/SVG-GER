package svgger.commands;

/** Abstract class representing a command. */
public abstract class Command {
    /**
     * Performs an action associated with the command.
     * @param interpreter Program that is the command associated with.
     */
    public abstract void run(Interpreter interpreter);
}
