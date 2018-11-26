package svgger.commands.svg;

import java.awt.*;

/** The line of given parameters. */
public class SvgLine extends SvgInstruction {
    private Point originLocation;
    private Point currentLocation;
    private SvgStyle style;

    public SvgLine(Point originLocation, Point currentLocation, SvgStyle style) {
        this.originLocation = originLocation;
        this.currentLocation = currentLocation;
        this.style = new SvgStyle(style); // Deep copy is required since the color can be changed throughout the program and it would lead to the same color for all the lines, because commands are executed when parsing is done.
    }

    @Override
    public String getSvgInstruction() {
        return "<line x1=\"" + originLocation.x + "\" y1=\"" + originLocation.y + "\" x2=\"" + currentLocation.x + "\" y2=\"" + currentLocation.y + "\" style=\"" + style.getSvgInstruction() + "\" />";
    }
}
