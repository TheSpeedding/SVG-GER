package svgger.commands;

import svgger.commands.statements.Statement;
import svgger.commands.svg.*;

import java.awt.*;
import java.io.*;
import java.util.*;

import static svgger.commands.Interpreter.Direction.*;

/** Represents a SVGGER runnable program. */
public class Interpreter {
    /** Enum representing directions. */
    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    private PrintStream outputStream;
    private String programName;
    private ArrayList<Statement> commands;
    private ArrayList<Function> functions;
    private ArrayList<Instruction> svgInstructions;

    private Direction currentDirection;
    private Point currentLocation;
    private boolean penDown;

    private int width;
    private int height;

    /**
     * Initialize an interpreter.
     * @param name Name of the program.
     * @param stream Output stream, commonly its an SVG file.
     * @param width Width of the canvas.
     * @param height Height of the canvas.
     */
    public Interpreter(String name, PrintStream stream, int width, int height) {
        svgInstructions = new ArrayList<>();
        functions = new ArrayList<>();
        commands = new ArrayList<>();

        currentDirection = RIGHT;
        currentLocation = new Point(0, 0);
        penDown = false;

        programName = name;
        outputStream = stream;
        this.width = width;
        this.height = height;
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

    /** Decides whether the pen is up. */
    public boolean isPenUp() {
        return !penDown;
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

    /** Compiles the program into the given printstream. */
    public static void run(Interpreter interpreter) {
        for (Statement cmd : interpreter.commands) {
            cmd.run(interpreter);
        }
        interpreter.write();
    }

    /** Writes the result into the printstream. */
    private void write() {
        for (Instruction instruction : svgInstructions) {
            outputStream.println(instruction.getSvgInstruction());
        }
    }
}
