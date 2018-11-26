package svgger.stdlib;

import svgger.commands.Interpreter;

/** Class representing standard library. */
public class StandardLibrary {
    public static void include(Interpreter interpreter) {
        interpreter.addFunction(new PenDown());
        interpreter.addFunction(new PenUp());
        interpreter.addFunction(new TurnLeft());
        interpreter.addFunction(new TurnRight());
        interpreter.addFunction(new GoTo());
        interpreter.addFunction(new Move());
        interpreter.addFunction(new SetColor());
        interpreter.addFunction(new SetWidth());
    }
}
