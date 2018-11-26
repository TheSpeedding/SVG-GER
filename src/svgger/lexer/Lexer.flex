package svgger.lexer;

import java.io.*;
import java_cup.runtime.*;

%%

%class Lexer
%cup

%final
%public

%line
%column

%{
    private Symbol createSymbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol createSymbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

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
IDENTIFIER = {LETTER}[a-zA-Z0-9_]*
LBRA = \{
RBRA = \}
LPAR = \(
RPAR = \)
NUMBER = {DIGIT}+
OPPLUS = \+
OPMINUS = \-
OPMUL = \*
OPDIV = \/
DOT = \.
REPEAT = [rR][eE][pP][eE][aA][tT]

%%

<MAIN> {

    /** Keywords. **/

    {PROGRAM}           {
                            return createSymbol(sym.PROGRAM);
                        }
    {FUNCTION}          {
                            return createSymbol(sym.FUNCTION);
                        }
    {LBRA}              {
                            return createSymbol(sym.LBRA);
                        }
    {RBRA}              {
                            return createSymbol(sym.RBRA);
                        }
    {LPAR}              {
                            return createSymbol(sym.LPAR);
                        }
    {RPAR}              {
                            return createSymbol(sym.RPAR);
                        }
    {OPPLUS}            {
                            return createSymbol(sym.OPPLUS);
                        }
    {OPMINUS}           {
                            return createSymbol(sym.OPMINUS);
                        }
    {OPMUL}             {
                            return createSymbol(sym.OPMUL);
                        }
    {OPDIV}             {
                            return createSymbol(sym.OPDIV);
                        }
    {DOT}               {
                            return createSymbol(sym.DOT);
                        }
    {REPEAT}            {
                            return createSymbol(sym.REPEAT);
                        }

    /** Other tokens. **/

    {NUMBER}            {
                            return createSymbol(sym.NUMBER, new Integer(yytext()));
                        }
    {IDENTIFIER}        {
                            return createSymbol(sym.IDENTIFIER, new String(yytext()));
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
                            return createSymbol(sym.EOF);
                        }
}

<SHORT_COMMENT> {
    \n                  {
                            yybegin(MAIN);
                        }
    .                   {
                            // Go out with whitespaces.
                        }
    <<EOF>>             {
                            return createSymbol(sym.EOF);
                        }
}

<LONG_COMMENT> {
    \*\/                {
                            yybegin(MAIN);
                        }
    .                   {
                            // Go out with whitespaces.
                        }
    <<EOF>>             {
                            return createSymbol(sym.EOF);
                        }
}
