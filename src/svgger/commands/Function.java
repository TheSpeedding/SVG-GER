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

    /**
     * Initializes an object.
     * @param name Name of the function.
     * @param parameterKeys Parameters of the function.
     * @param command Body of the function.
     */
    public Function(String name, SvggerList<VariableIdentifier> parameterKeys, Statement command) {
        this.name = name;
        this.parameterKeys = parameterKeys;
        this.command = command;
    }

    /**
     * Initializes an object.
     * @param name Name of the function.
     * @param command Body of the function.
     */
    public Function(String name, Statement command) {
        this.name = name;
        this.parameterKeys = new SvggerList<>();
        this.command = command;
    }

    /**
     * Initializes an object.
     * @param name Name of the function.
     * @param parameterKeys Parameters of the function.
     */
    public Function(String name, SvggerList<VariableIdentifier> parameterKeys) {
        this.name = name;
        this.parameterKeys = parameterKeys;
    }

    /**
     * Initializes an object.
     * @param name Name of the function.
     */
    public Function(String name) {
        this.name = name;
        this.parameterKeys = new SvggerList<>();
    }

    /**
     * Returns name of the function.
     * @return Name of the function.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns parameter keys for the function.
     * @return Parameters.
     */
    public SvggerList<VariableIdentifier> getParameterKeys() {
        return parameterKeys;
    }

    /**
     * Adds a new command to the function.
     * @param command Command to be added.
     */
    public void addCommand(Statement command) {
        this.command = command;
    }

    public boolean run(Program program, SvggerList<Expression> parameterValues, HashMap<VariableIdentifier, Integer> previousContext) {
        if (parameterValues.size() != parameterKeys.size())
            throw new InvalidParameterException("Number of parameters at the function call " + name + " does not match.");

        HashMap<VariableIdentifier, Integer> varTable = new HashMap<>();
        for (int i = 0; i < parameterKeys.size(); ++i) {
            varTable.put(parameterKeys.get(i), parameterValues.get(i).getValue(previousContext));
        }

        return command.run(program, varTable);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterKeys.size() - 1; ++i) {
            sb.append(parameterKeys.get(i) + ", ");
        }
        if (parameterKeys.size() > 0) {
            sb.append(parameterKeys.get(parameterKeys.size() - 1));
        }
        return "FUNCTION " + name + "(" + sb.toString() + ") " + command.toString();
    }
}
