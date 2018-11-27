package svgger.commands.operators;

/** Class representing PLUS operator. */
public class OperatorPlus extends Operator {
    @Override
    public int calculate(int fst, int snd) {
        return fst + snd;
    }

    @Override
    public String toString() {
        return "+";
    }
}
