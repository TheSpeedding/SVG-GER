package svgger.commands;

import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.commands.svg.*;
import svgger.commands.svg.SvgStyle;
import svgger.stdlib.StandardLibrary;
import svgger.util.SvggerList;

import java.awt.*;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.*;

import static svgger.commands.Program.Direction.*;

/** Represents a SVGGER runnable program. */
public class Program {
    /** Enum representing directions. */
    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    /** Enum representing state of the program. */
    public enum State {
        NOT_STARTED_YET, RUNNING, EXCEPTION_OCCURRED, RAN_TO_COMPLETION
    }

    private String programName;
    private Statement command; // In most of the cases, this will be a block of code.
    private SvggerList<Function> functions;

    private SvggerList<SvgInstruction> svgInstructions;

    private Direction currentDirection;
    private Point currentLocation;
    private boolean penDown;
    private SvgStyle style;

    private State state;

    public Program(String name, Statement command, SvggerList<Function> functions) {
        svgInstructions = new SvggerList<>();
        this.functions = new SvggerList<>();

        StandardLibrary.include(this);

        for (Function fn : functions) {
            if (this.functions.indexOf(fn) != -1) throw new InvalidParameterException("Attempt to redefine function with name " + fn.getName() + ".");
            this.functions.add(fn);
        }

        this.command = command;
        programName = name;

        currentDirection = RIGHT;
        currentLocation = new Point(0, 0);
        penDown = false;
        style = new SvgStyle();
        state = State.NOT_STARTED_YET;
    }

    /** Returns the style for lines. */
    public SvgStyle getStyle() {
        return style;
    }

    /** Returns current direction. */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /** Sets the new direction. */
    public void setDirection(Direction direction) {
        currentDirection = direction;
    }

    /** Returns current location. */
    public Point getCurrentLocation() {
        return currentLocation;
    }

    /** Sets the new location. */
    public void setLocation(Point location) {
        currentLocation = location;
    }

    /** Decides whether the pen is down. */
    public boolean isPenDown() {
        return penDown;
    }

    /** Makes the pen down. */
    public void setPenDown() {
        penDown = true;
    }

    /** Makes the pen up. */
    public void setPenUp() {
        penDown = false;
    }

    /** Returns name of the program associated with this interpreter. */
    public String getProgramName() {
        return programName;
    }

    /** Adds function to the program. */
    public void addFunction(Function fn) {
        functions.add(fn);
    }

    /** Returns the function by name. */
    public Function getFunction(String name) {
        for (Function f : functions) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    /** Adds SVG instruction to the program. */
    public void addSvgInstruction(SvgInstruction svg) {
        svgInstructions.add(svg);
    }

    /** Compiles the program. */
    public void run() {
        if (state != State.NOT_STARTED_YET) return;

        state = State.RUNNING;

        HashMap<VariableIdentifier, Integer> varTable = new HashMap<>(); // Program is executed with no parameters, therefore there are no variables.

        try {
            command.run(this, varTable);
        } catch (Exception e) {
            state = State.EXCEPTION_OCCURRED;
            throw e;
        }

        state = State.RAN_TO_COMPLETION;
    }

    /** Writes the output into given printstream. */
    public void write(PrintStream ps) {
        for (SvgInstruction svg : svgInstructions) {
            ps.println(svg.getSvgInstruction());
        }
    }
}
