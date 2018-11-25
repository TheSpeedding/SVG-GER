package svgger.commands.expressions;

import java.util.HashMap;

/** Class representing a number constant. */
public class NumberConstant extends Expression {
    private int value;

    public NumberConstant(int value) {
        this.value = value;
    }

    /** Returns the value of the number constant. */
    @Override
    public int getValue(HashMap<VariableIdentifier, Integer> varTable) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
