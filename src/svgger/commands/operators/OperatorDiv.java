package svgger.commands.operators;

public class OperatorDiv extends Operator {
    @Override
    public int calculate(int fst, int snd) {
        return fst / snd;
    }

    @Override
    public String toString() {
        return "/";
    }
}
