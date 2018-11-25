package svgger.commands;

import java.io.*;
import java.util.*;

/** Represents a SVGGER runnable program. */
public class Interpreter extends Command {
    private String programName;
    private ArrayList<Command> commands = new ArrayList<>();
    private ArrayList<Function> functions = new ArrayList<>();

    /** Returns name of the program associated with this instance of interpreter. */
    public String getProgramName() {
        return programName;
    }

    /**
     * Compiles the program into the given printstream, commonly its a SVG file.
     * @param ps Printstream that should the program be compiled into.
     */
    public void compile(PrintStream ps) {

    }

    @Override
    public void run() {

    }
}
