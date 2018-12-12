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

    /**
     * Initializes an object.
     * @param name Name of the program.
     * @param command Body of the program.
     * @param functions Functions defined in the program.
     */
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

    /**
     * Returns the style for lines.
     * @return Style for the lines.
     */
    public SvgStyle getStyle() {
        return style;
    }

    /** Returns current direction.
     * @return Current direction.
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /** Sets the new direction
     * @param direction New direction.
     */
    public void setDirection(Direction direction) {
        currentDirection = direction;
    }

    /** Returns current location.
     * @return Current location.
     */
    public Point getCurrentLocation() {
        return currentLocation;
    }

    /** Sets the new location.
     * @param location New location.
     */
    public void setLocation(Point location) {
        currentLocation = location;
    }

    /** Decides whether the pen is down.
     * @return True if pen down. False if pen up.
     */
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

    /** Returns name of the program associated with this interpreter.
     * @return Name of the program.
     */
    public String getProgramName() {
        return programName;
    }

    /** Adds function to the program.
     * @param fn Function to add.
     */
    public void addFunction(Function fn) {
        functions.add(fn);
    }

    /** Returns the function by name.
     * @param name Name of the function.
     * @return Corresponding function. Null if does not exist.
     */
    public Function getFunction(String name) {
        for (Function f : functions) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    /** Adds SVG instruction to the program.
     * @param svg SVG instruction.
     */
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

    /** Writes the output into given printstream.
     * @param ps Printstream.
     */
    public void write(PrintStream ps) {
        for (SvgInstruction svg : svgInstructions) {
            ps.println(svg.getSvgInstruction());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Function fn : functions) {
            sb.append(fn.toString());
        }
        return "PROGRAM " + programName + " " + command.toString() + sb.toString();
    }
}
