package svgger.commands.expressions;

import java.util.HashMap;

/** Class representing a variable identifier. */
public class VariableIdentifier extends Expression {
    private String identifier;

    /** Returns the identifier. */
    public String getIdentifier() {
        return identifier;
    }

    /** Returns value of the variable. */
    public int getValue(HashMap<VariableIdentifier, Integer> varTable) {
        return varTable.get(this);
    }

    public VariableIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /* No setValue method implemented, because in current situation variables are only used for passing parameters to functions.
     * Variables are technically not considered as "variables", because they are immutable. This should be reworked later, if needed.
     */

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return ((VariableIdentifier)obj).identifier.equals(this.identifier);
    }

    @Override
    public String toString() {
        return identifier;
    }
}
