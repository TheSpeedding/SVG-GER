package svgger.commands.operators;

/** Class representing MINUS operator. */
public class OperatorMinus extends Operator {
    @Override
    public int calculate(int fst, int snd) {
        return fst - snd;
    }

    @Override
    public String toString() {
        return "-";
    }
}
