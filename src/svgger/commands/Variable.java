package svgger.commands;

/** Class representing a variable. */
public class Variable {
    private String name;
    private int value;

    /** Returns identifier. */
    public String getName() {
        return name;
    }

    /** Returns value of the variable. */
    public int getValue() {
        return value;
    }

    // No setValue method implemented, because in current situation variables are only used for passing parameters to functions.
}
