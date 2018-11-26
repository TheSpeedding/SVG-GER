package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;
import svgger.util.SvggerList;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/** Standard function that sets the color for the lines. */
public class SetRandomColor extends Function {
    private static Random random = new Random();

    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            program.getStyle().setColor(new Color(r, g, b));

            return true;
        }
    }

    public SetRandomColor() {
        super("SET_RANDOM_COLOR");
        addCommand(new HelperStatement());
    }
}