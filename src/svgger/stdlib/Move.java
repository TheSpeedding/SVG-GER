package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
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
        public void run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            var currentDirection = program.getCurrentDirection();
            var originLocation = program.getCurrentLocation();

            var distance = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.

            switch (currentDirection) {
                case UP:
                    program.setLocation(new Point(originLocation.x, originLocation.y - distance));
                    break;
                case RIGHT:
                    program.setLocation(new Point(originLocation.x + distance, originLocation.y));
                    break;
                case DOWN:
                    program.setLocation(new Point(originLocation.x, originLocation.y + distance));
                    break;
                case LEFT:
                    program.setLocation(new Point(originLocation.x - distance, originLocation.y));
                    break;
            }

            var currentLocation = program.getCurrentLocation();

            if (program.isPenDown()) {
                program.addSvgInstruction(new SvgLine(originLocation, currentLocation, program.getStyle()));
            }
        }
    }

    public Move() {
        super("MOVE", new SvggerList<>(new VariableIdentifier("x")));
        addCommand(new HelperStatement());
    }
}