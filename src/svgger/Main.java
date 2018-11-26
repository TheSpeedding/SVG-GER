package svgger;

import svgger.commands.Program;
import svgger.lexer.Lexer;
import svgger.parser.Parser;

import java.io.*;

public class Main {

    /**
     * Runs the compiler and produces SVG output file with the same name.
     * @param args Arguments passed to the compiler.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: <input file> <width> <height>");
        }
        else {
            String pathToSourceCode = args[0];
            int widthOfCanvas = 800, heightOfCanvas = 800;

            try {
                widthOfCanvas = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                System.err.println("Invalid number: " + args[1]);
            }

            try {
                heightOfCanvas = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException e) {
                System.err.println("Invalid number: " + args[2]);
            }

            try {

                Parser p = new Parser(new Lexer(new FileReader(pathToSourceCode)));

                Program program = (Program)p.parse().value;

                new Interpreter(new PrintStream(new File(pathToSourceCode.split("\\.")[0] + ".svg")), program, widthOfCanvas, heightOfCanvas).run();

            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
