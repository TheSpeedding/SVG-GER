package svgger.commands;

import svgger.commands.statements.*;
import svgger.commands.expressions.*;
import svgger.util.SvggerList;

import java.security.InvalidParameterException;
import java.util.*;

/** Class representing function declaration. */
public class Function {
    private String name;
    private SvggerList<VariableIdentifier> parameterKeys;
    private SvggerList<Statement> commands = new SvggerList<>();

    public Function(String name, SvggerList<VariableIdentifier> parameterKeys) {
        this.name = name;
        this.parameterKeys = parameterKeys;
    }

    public Function(String name) {
        this.name = name;
        this.parameterKeys = new SvggerList<>();
    }

    /** Returns parameter keys for the function. */
    public SvggerList<VariableIdentifier> getParameterKeys() {
        return parameterKeys;
    }

    /** Adds a new command to the function. */
    public void addCommand(Statement command) {
        commands.add(command);
    }

    public void run(Interpreter interpreter, SvggerList<Integer> parameterValues) {
        if (parameterValues.size() != parameterKeys.size())
            throw new InvalidParameterException("Number of parameters at the function call " + name + " does not match.");

        HashMap<VariableIdentifier, Integer> varTable = new HashMap<>();
        for (int i = 0; i < parameterKeys.size(); ++i) {
            varTable.put(parameterKeys.get(i), parameterValues.get(i));
        }
    }
}
