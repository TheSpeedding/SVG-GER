package svgger;

import svgger.lexer.Lexer;

public class Main {

    /**
     * Runs the compiler and produces SVG output file with the same name.
     * @param args Arguments passed to the compiler.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: <input file> <width> <height>");
        }
        else {
            String pathToSourceCode = args[0];
            int widthOfCanvas, heightOfCanvas;

            try {
                widthOfCanvas = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number: " + args[1]);
            }

            try {
                heightOfCanvas = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number: " + args[2]);
            }


            Lexer scanner = null;
            try {
                java.io.FileInputStream stream = new java.io.FileInputStream(args[0]);
                java.io.Reader reader = new java.io.InputStreamReader(stream);
                scanner = new Lexer(reader);
            }
            catch (java.io.FileNotFoundException e) {
                System.out.println("File not found: " + args[0]);
            }
            catch (java.io.IOException e) {
                System.out.println("IO error scanning file :" + args[0]);
            }
        }
    }
}
