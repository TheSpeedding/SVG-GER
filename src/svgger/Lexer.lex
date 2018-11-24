package svgger;

import java.io.*;
import java_cup.runtime.*;
%%

%class Lexer
%final
%standalone
%apiprivate
%line

%init{
    yybegin(MAIN);
%init}

%state MAIN, SHORT_COMMENT, LONG_COMMENT

DIGIT = [0-9]
LETTER = [a-zA-Z]
WHITESPACE = [ \t\r\n]
TURN = [tT][uU][rR][nN]

PROGRAM = [pP][rR][oO][gG][rR][aA][mM]
FUNCTION = [fF][uU][nN][cC][tT][iI][oO][nN]
IDENTIFIER = {LETTER}[{LETTER}|{DIGIT}]*
LBRA = \{
RBRA = \}
LPAR = \(
RPAR = \)
PENDOWN = [pP][eE][nN]_[dD][oO][wW][nN]
PENUP = [pP][eE][nN]_[uU][pP]
MOVE = [mM][oO][vV][eE]
MOVETO = {MOVE}_[tT][oO]
SETCOLOR = [sS][eE][tT]_[cC][oO][lL][oO][rR]
INTEGER = [+-]?{DIGIT}+
OPPLUS = +
OPMINUS = -
OPMUL = \*
OPDIV = \/
DOT = \.
REPEAT = [rR][eE][pP][eE][aA][tT]
TURNLEFT = {TURN}_[lL][eE][fF][tT]
TURNRIGHT = {TURN}_[rR][iI][gG][hH][tT]


%%

<MAIN> {

    \/\/      {
                    yybegin(SHORT_COMMENT);
              }
    \/\*      {
                    yybegin(LONG_COMMENT);
              }
}

<SHORT_COMMENT> {
    \n          {
                    yybegin(MAIN);
                }
    .           // Go out with whitespaces.
}

<LONG_COMMENT> {
    \*\/        {
                    yybegin(MAIN);
                }
    .           // Go out with whitespaces.
}