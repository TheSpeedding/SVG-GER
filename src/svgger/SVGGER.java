package svgger;

public class SVGGER {

    /**
     * Runs the compiler and produces SVG output file with the same name.
     * @param args Arguments passed to the compiler.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java SVGGER <input file> <width> <height>");
        }
        else {
            String pathToSourceCode = args[0];
            int widthOfCanvas, heightOfCanvas;

            try {
                widthOfCanvas = Integer.parseInt(args[1]);
                heightOfCanvas = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }


        }
    }
}
