package svgger.commands.operators;

/** Abstract class for basic operators. */
public abstract class Operator {
    /**
     * Calculates the result.
     * @param fst First operand.
     * @param snd Second operand.
     * @return The result of the operator.
     */
    public abstract int calculate(int fst, int snd);
}
