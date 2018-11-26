# SVG-GER

SVG-GER is a simple programming language that is meant to creating SVG pictures consisting of lines only. The language is considered to be slightly functional, because no assignment operator is supported at the moment. Files with the source code usually have extension `*.svgger`. In the compilation process, arguments with path to source code, width of the canvas and height of the canvas are passed to the Java interpreter. The program starts at the point (0,0) in the direction to the East and with pen put up. The language support following basic commands:
  - `PEN_UP` sets the pen up so it draws nothing nomore
  - `PEN_DOWN` sets the pen down so it starts drawing
  - `TURN_LEFT` turns the direction to the right, e.g. from the West to the North
  - `TURN_RIGHT` turns the direction to the left, e.g. from the West to the South
  - `MOVE(x)` moves the pen in the set direction for x pixels
  - `GO_TO(x, y)` absolute move of the pen to the given coordinates (x,y) without changing a direction
  - `REPEAT n` repeats the following statement n-times, typically a block of the code
  - `SET_COLOR(r,g,b)` sets the color of the lines to the RGB color given by parameters
  - `SET_WIDTH(n)` sets the width of the lines

However you can define your own functions with any parameters you want. But consider that they all are of `void` type only, i.e. they have no return value. You can also define a recursive function to draw some interesting figures. You may have noticed, that there is no `IF` statement or boolean expressions in the language. Therefore, a command `RETURN_IF_ZERO(x)` was implemented, which returns from the function at the point of calling if the parameter x is equal to zero. So you may need some special parameter in your function demarked as a counter, which decrements in each recursive call of the function.

The program in SVG-GER has a following structure:
```
PROGRAM MyProgram {
    ...
}
FUNCTION MyFirstFunction() {
    // This function does nothing.
}
FUNCTION MySecondFunction(x, y, z) {
    /*
     * This function does nothing, too.
     */
}
```

You may define any number of functions, but the program can be without any function, too. Positioning of the functions does not matter, but the `PROGRAM` block must be in the beginning of the file. As you can see, you can also use C-like comments. Talking about identifiers, they all must start with a letter. Then, any letter, number of underscore can follow. Keywords are case-insensitive, identifiers are case-sensitive. Each command (i.e. function call) must be ended with a dot operator. Functions without parameters are called without parentheses, functions with parameters are required to have parentheses in which you input your parameters for given call.

The interpreter uses JFlex for lexical analysis and Cup to create a parser. Building a syntax tree and generating SVG code is written in pure Java. You can find more examples of the source code in the particular folder. Standard functions are not hardwired to the lexer and parser, they are threaten same like user-defined function. Therefore, the language might be easily extended with new features.