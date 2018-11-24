package svgger;

public class Main {
    public static void main(String[] args) {
        String pathToSourceCode = args[0];
        int widthOfCanvas, heightOfCanvas;

        try {
            widthOfCanvas = Integer.parseInt(args[1]);
            heightOfCanvas = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }

        Sentence
    }
}
