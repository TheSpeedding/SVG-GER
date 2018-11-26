package svgger.commands.svg;

import java.awt.*;

/** Class representing SVG line style. */
public class SvgStyle extends SvgInstruction {
    private Color color;
    private int width;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public SvgStyle() {
        color = Color.BLACK;
        width = 1;
    }

    public SvgStyle(SvgStyle style) {
        color = style.color;
        width = style.width;
    }

    @Override
    public String getSvgInstruction() {
        return "stroke: rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "); stroke-width: " + width;
    }
}
