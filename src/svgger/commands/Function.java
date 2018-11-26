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
    private Statement command; // In most of the cases, this will be a block of code.

    public Function(String name, SvggerList<VariableIdentifier> parameterKeys, Statement command) {
        this.name = name;
        this.parameterKeys = parameterKeys;
        this.command = command;
    }

    public Function(String name, Statement command) {
        this.name = name;
        this.parameterKeys = new SvggerList<>();
        this.command = command;
    }

    public Function(String name, SvggerList<VariableIdentifier> parameterKeys) {
        this.name = name;
        this.parameterKeys = parameterKeys;
    }

    public Function(String name) {
        this.name = name;
        this.parameterKeys = new SvggerList<>();
    }

    /** Returns name of the function. */
    public String getName() {
        return name;
    }

    /** Returns parameter keys for the function. */
    public SvggerList<VariableIdentifier> getParameterKeys() {
        return parameterKeys;
    }

    /** Adds a new command to the function. */
    public void addCommand(Statement command) {
        this.command = command;
    }

    public void run(Program program, SvggerList<Expression> parameterValues, HashMap<VariableIdentifier, Integer> previousContext) {
        if (parameterValues.size() != parameterKeys.size())
            throw new InvalidParameterException("Number of parameters at the function call " + name + " does not match.");

        HashMap<VariableIdentifier, Integer> varTable = new HashMap<>();
        for (int i = 0; i < parameterKeys.size(); ++i) {
            varTable.put(parameterKeys.get(i), parameterValues.get(i).getValue(previousContext));
        }

        command.run(program, varTable);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return ((Function)obj).name.equals(this.name);
    }
}
