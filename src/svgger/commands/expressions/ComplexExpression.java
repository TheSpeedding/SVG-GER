package svgger.commands.expressions;

import svgger.commands.operators.*;

import java.util.HashMap;

/** Class representing expression which includes a binary operator. */
public class ComplexExpression extends Expression {
    private Operator op;
    private Expression fst;
    private Expression snd;

    public ComplexExpression(Expression fst, Operator op, Expression snd) {
        this.op = op;
        this.fst = fst;
        this.snd = snd;
    }

    /** Returns value of the complex expression. */
    @Override
    public int getValue(HashMap<VariableIdentifier, Integer> varTable) {
        return op.calculate(fst.getValue(varTable), snd.getValue(varTable));
    }

    @Override
    public String toString() {
        return fst.toString() + op.toString() + snd.toString();
    }
}
