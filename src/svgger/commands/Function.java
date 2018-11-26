package svgger.commands;

import svgger.commands.statements.*;
import svgger.commands.expressions.*

import java.security.InvalidParameterException;
import java.util.*;

/** Class representing function declaration. */
public class Function {
    private String name;
    private ArrayList<Statement> commands = new ArrayList<>();
    private ArrayList<VariableIdentifier> parameterKeys = new ArrayList<>();

    public Function(String name) {
        this.name = name;
    }

    public void addCommand(Statement command) {
        commands.add(command);
    }

    public void run(Interpreter interpreter, FunctionParameters parameterValues) {
        if (parameterValues.size() != parameterKeys.size())
            throw new InvalidParameterException("Number of parameters at the function call " + name + " does not match.");

        HashMap<VariableIdentifier, Integer> varTable = new HashMap<>();
        for (int i = 0; i < parameterKeys.size(); ++i) {
            varTable.put(parameterKeys.get(i), parameterValues.get(i));
        }
    }
}
