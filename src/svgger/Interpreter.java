package svgger;

import svgger.commands.Program;

import java.io.*;

/** Class representing an interpreter. */
public class Interpreter {
    private PrintStream ps;
    private Program program;
    private int width;
    private int height;

    public Interpreter(PrintStream ps, Program program, int width, int height) {
        this.ps = ps;
        this.program = program;
        this.width = width;
        this.height = height;
    }

    /** Runs the interpreter and produces SVG file. */
    public void run() {
        ps.println("<!-- Program: " + program.getProgramName() + " -->");
        ps.println("<svg width=\"" + width + "\" height=\"" + height + "\">");

        program.run();
        program.write(ps);

        ps.println("</svg>");
    }
}
