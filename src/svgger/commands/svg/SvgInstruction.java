package svgger.commands.svg;

/** Instruction for the SVG language. */
public abstract class SvgInstruction {
    /** Returns instruction SVG code. */
    public abstract String getSvgInstruction();

    @Override
    public String toString() {
        return getSvgInstruction();
    }
}
