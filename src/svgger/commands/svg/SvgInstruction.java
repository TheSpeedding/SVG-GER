package svgger.commands.svg;

/** Instruction for the SVG language. */
public abstract class SvgInstruction {
    /** Returns instruction SVG code.
     * @return String representation of the instruction.
     */
    public abstract String getSvgInstruction();

    @Override
    public String toString() {
        return getSvgInstruction();
    }
}
