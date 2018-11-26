package svgger.commands.svg;

import java.awt.*;

/** Class representing SVG line style. */
public class SvgStyle extends SvgInstruction {
    private Color color = Color.BLACK;
    private int width = 1;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String getSvgInstruction() {
        return "stroke: rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "); stroke-width: " + width;
    }
}
