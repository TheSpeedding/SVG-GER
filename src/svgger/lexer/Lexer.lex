package svgger.lexer;

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
IDENTIFIER = {LETTER}[a-zA-Z0-9]*
LBRA = \{
RBRA = \}
LPAR = \(
RPAR = \)
PENDOWN = [pP][eE][nN]_[dD][oO][wW][nN]
PENUP = [pP][eE][nN]_[uU][pP]
MOVE = [mM][oO][vV][eE]
GOTO = [gG][oO]_[tT][oO]
SETCOLOR = [sS][eE][tT]_[cC][oO][lL][oO][rR]
INTEGER = [+-]?{DIGIT}+
OPPLUS = \+
OPMINUS = \-
OPMUL = \*
OPDIV = \/
DOT = \.
REPEAT = [rR][eE][pP][eE][aA][tT]
TURNLEFT = {TURN}_[lL][eE][fF][tT]
TURNRIGHT = {TURN}_[rR][iI][gG][hH][tT]


%%

<MAIN> {
    {PROGRAM}           {
                            System.out.println("PROGRAM");
                        }
    {FUNCTION}          {
                            System.out.println("FUNCTION");
                        }
    {LBRA}              {
                            System.out.println("LBRA");
                        }
    {RBRA}              {
                            System.out.println("RBRA");
                        }
    {LPAR}              {
                            System.out.println("LPAR");
                        }
    {RPAR}              {
                            System.out.println("RPAR");
                        }
    {PENDOWN}           {
                            System.out.println("PEN DOWN");
                        }
    {PENUP}             {
                            System.out.println("PEN UP");
                        }
    {MOVE}              {
                            System.out.println("MOVE");
                        }
    {GOTO}              {
                            System.out.println("GO TO");
                        }
    {SETCOLOR}          {
                            System.out.println("SET COLOR");
                        }
    {INTEGER}           {
                            System.out.println("INTEGER: " + yytext());
                        }
    {OPPLUS}            {
                            System.out.println("PLUS");
                        }
    {OPMINUS}           {
                            System.out.println("MINUS");
                        }
    {OPMUL}             {
                            System.out.println("MUL");
                        }
    {OPDIV}             {
                            System.out.println("DIV");
                        }
    {DOT}               {
                            System.out.println("DOT");
                        }
    {TURNLEFT}          {
                            System.out.println("TURN LEFT");
                        }
    {TURNRIGHT}         {
                            System.out.println("TURN RIGHT");
                        }
    {REPEAT}            {
                            System.out.println("REPEAT");
                        }
    {IDENTIFIER}        {
                            System.out.println("IDENTIFIER: " + yytext());
                        }
    \/\/                {
                            yybegin(SHORT_COMMENT);
                        }
    \/\*                {
                            yybegin(LONG_COMMENT);
                        }
    {WHITESPACE}        {
                            // Go out with whitespaces.
                        }
    <<EOF>>             {
                            System.out.println("EOF");
                        }
}

<SHORT_COMMENT> {
    \n                  {
                            yybegin(MAIN);
                        }
    .                   {
                            // Go out with whitespaces.
                        }
}

<LONG_COMMENT> {
    \*\/                {
                            yybegin(MAIN);
                        }
    .                   {
                            // Go out with whitespaces.
                        }
}
