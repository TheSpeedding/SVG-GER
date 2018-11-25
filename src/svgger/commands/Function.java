package svgger.commands;

import svgger.commands.expressions.Variable;

import java.util.*;

/** Class representing function declaration. */
public class Function extends Command {
    private String name;
    private ArrayList<Command> commands = new ArrayList<>();
    private ArrayList<Variable> parameters = new ArrayList<>();

    @Override
    public void run(Interpreter interpreter) {

    }
}
