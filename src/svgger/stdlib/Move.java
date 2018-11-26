package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Interpreter;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.commands.svg.SvgLine;
import svgger.util.SvggerList;

import java.awt.*;
import java.util.HashMap;

/** Standard function that moves the pen relatively. */
public class Move extends Function {
    private class HelperStatement extends Statement {
        @Override
        public void run(Interpreter interpreter, HashMap<VariableIdentifier, Integer> varTable) {
            var currentDirection = interpreter.getCurrentDirection();
            var originLocation = interpreter.getCurrentLocation();

            var distance = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.

            switch (currentDirection) {
                case UP:
                    interpreter.setLocation(new Point(originLocation.x, originLocation.y - distance));
                    break;
                case RIGHT:
                    interpreter.setLocation(new Point(originLocation.x + distance, originLocation.y));
                    break;
                case DOWN:
                    interpreter.setLocation(new Point(originLocation.x, originLocation.y + distance));
                    break;
                case LEFT:
                    interpreter.setLocation(new Point(originLocation.x - distance, originLocation.y));
                    break;
            }

            var currentLocation = interpreter.getCurrentLocation();

            if (interpreter.isPenDown()) {
                interpreter.addSvgInstruction(new SvgLine(originLocation, currentLocation, interpreter.getStyle()));
            }
        }
    }

    public Move() {
        super("MOVE", new SvggerList<>(new VariableIdentifier("x")));
        addCommand(new HelperStatement());
    }
}