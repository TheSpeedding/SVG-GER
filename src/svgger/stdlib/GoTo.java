package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.commands.svg.SvgLine;
import svgger.util.SvggerList;

import java.awt.*;
import java.util.HashMap;

/** Standard function that moves the pen absolutely. */
public class GoTo extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            var currentDirection = program.getCurrentDirection();
            var originLocation = program.getCurrentLocation();

            var x = getParameterKeys().get(0).getValue(varTable); // This variable is given by the variable in the constructor below.
            var y = getParameterKeys().get(1).getValue(varTable); // This variable is given by the variable in the constructor below.

            program.setLocation(new Point(x, y));

            var currentLocation = program.getCurrentLocation();

            if (program.isPenDown()) {
                program.addSvgInstruction(new SvgLine(originLocation, currentLocation, program.getStyle()));
            }

            return true;
        }
    }

    public GoTo() {
        super("GO_TO", new SvggerList<>(new SvggerList<>(new VariableIdentifier("x")), new VariableIdentifier("y")));
        addCommand(new HelperStatement());
    }
}