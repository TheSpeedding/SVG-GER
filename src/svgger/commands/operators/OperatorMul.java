package svgger.commands.operators;

/** Class representing MUL operator. */
public class OperatorMul extends Operator {
    @Override
    public int calculate(int fst, int snd) {
        return fst * snd;
    }

    @Override
    public String toString() {
        return "*";
    }
}
