package svgger.stdlib;

import svgger.commands.Function;
import svgger.commands.Program;
import svgger.commands.expressions.VariableIdentifier;
import svgger.commands.statements.Statement;

import java.util.HashMap;

/** Standard function that turns the pen right. */
public class TurnRight extends Function {
    private class HelperStatement extends Statement {
        @Override
        public boolean run(Program program, HashMap<VariableIdentifier, Integer> varTable) {
            switch (program.getCurrentDirection()) {
                case UP:
                    program.setDirection(Program.Direction.RIGHT);
                    break;
                case RIGHT:
                    program.setDirection(Program.Direction.DOWN);
                    break;
                case DOWN:
                    program.setDirection(Program.Direction.LEFT);
                    break;
                case LEFT:
                    program.setDirection(Program.Direction.UP);
                    break;
            }

            return true;
        }
    }

    public TurnRight() {
        super("TURN_RIGHT");
        addCommand(new HelperStatement());
    }
}