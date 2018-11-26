package svgger.stdlib;

import svgger.commands.Program;

/** Class representing standard library. */
public class StandardLibrary {
    public static void include(Program program) {
        program.addFunction(new PenDown());
        program.addFunction(new PenUp());
        program.addFunction(new TurnLeft());
        program.addFunction(new TurnRight());
        program.addFunction(new GoTo());
        program.addFunction(new Move());
        program.addFunction(new SetColor());
        program.addFunction(new SetWidth());
    }
}
