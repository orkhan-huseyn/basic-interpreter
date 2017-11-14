package com.csci.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    /**
     * Tokenizes input string and returns array list of tokens
     *
     * @param String input
     * @return ArrayList<Token>
     * */
    public ArrayList<Token> lex(String input) {

        // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();

        // Lexer logic begins here
        StringBuilder tokenPatternsBuffer = new StringBuilder();

        // append formatted strings to buffer
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));

        // compile token patterns
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);

        // match the patterns and add to list
        while (matcher.find()) {

            if (matcher.group(TokenType.FLOAT.name()) != null) {

                tokens.add(new Token(TokenType.FLOAT, matcher.group(TokenType.FLOAT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.INT.name()) != null) {

                tokens.add(new Token(TokenType.INT, matcher.group(TokenType.INT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.STRING.name()) != null) {

                tokens.add(new Token(TokenType.STRING, matcher.group(TokenType.STRING.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.CHAR.name()) != null) {

                tokens.add(new Token(TokenType.CHAR, matcher.group(TokenType.CHAR.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.BOOLEAN.name()) != null) {

                tokens.add(new Token(TokenType.BOOLEAN, matcher.group(TokenType.BOOLEAN.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPEINT.name()) != null) {

                tokens.add(new Token(TokenType.TYPEINT, matcher.group(TokenType.TYPEINT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPEFLOAT.name()) != null) {

                tokens.add(new Token(TokenType.TYPEFLOAT, matcher.group(TokenType.TYPEFLOAT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPESTRING.name()) != null) {

                tokens.add(new Token(TokenType.TYPESTRING, matcher.group(TokenType.TYPESTRING.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPECHAR.name()) != null) {

                tokens.add(new Token(TokenType.TYPECHAR, matcher.group(TokenType.TYPECHAR.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPEBOOL.name()) != null) {

                tokens.add(new Token(TokenType.TYPEBOOL, matcher.group(TokenType.TYPEBOOL.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.TYPEVOID.name()) != null) {

                tokens.add(new Token(TokenType.TYPEVOID, matcher.group(TokenType.TYPEVOID.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.FOR.name()) != null) {

                tokens.add(new Token(TokenType.FOR, matcher.group(TokenType.FOR.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.WHILE.name()) != null) {

                tokens.add(new Token(TokenType.WHILE, matcher.group(TokenType.WHILE.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.IF.name()) != null) {

                tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.ELSE.name()) != null) {

                tokens.add(new Token(TokenType.ELSE, matcher.group(TokenType.ELSE.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.RETURN.name()) != null) {

                tokens.add(new Token(TokenType.RETURN, matcher.group(TokenType.RETURN.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.BREAK.name()) != null) {

                tokens.add(new Token(TokenType.BREAK, matcher.group(TokenType.BREAK.name()), matcher.start()));
                continue;

            } else if (matcher.group(TokenType.CONTINUE.name()) != null) {

                tokens.add(new Token(TokenType.CONTINUE, matcher.group(TokenType.CONTINUE.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.IDENT.name()) != null) {

                tokens.add(new Token(TokenType.IDENT, matcher.group(TokenType.IDENT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.INCREMENT.name()) != null) {

                tokens.add(new Token(TokenType.INCREMENT, matcher.group(TokenType.INCREMENT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.DECREMENT.name()) != null) {

                tokens.add(new Token(TokenType.DECREMENT, matcher.group(TokenType.DECREMENT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.PLUS.name()) != null) {

                tokens.add(new Token(TokenType.PLUS, matcher.group(TokenType.PLUS.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.MINUS.name()) != null) {

                tokens.add(new Token(TokenType.MINUS, matcher.group(TokenType.MINUS.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.PROD.name()) != null) {

                tokens.add(new Token(TokenType.PROD, matcher.group(TokenType.PROD.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.DIV.name()) != null) {

                tokens.add(new Token(TokenType.DIV, matcher.group(TokenType.DIV.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.AND.name()) != null) {

                tokens.add(new Token(TokenType.AND, matcher.group(TokenType.AND.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.OR.name()) != null) {

                tokens.add(new Token(TokenType.OR, matcher.group(TokenType.OR.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.EQUALS.name()) != null) {

                tokens.add(new Token(TokenType.EQUALS, matcher.group(TokenType.EQUALS.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.ASSIGNMENT.name()) != null) {

                tokens.add(new Token(TokenType.ASSIGNMENT, matcher.group(TokenType.ASSIGNMENT.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.GREATEROREQUALS.name()) != null) {

                tokens.add(new Token(TokenType.GREATEROREQUALS, matcher.group(TokenType.GREATEROREQUALS.name()), matcher.start()));
                continue;

            } else if (matcher.group(TokenType.LESSOREQUALS.name()) != null) {

                tokens.add(new Token(TokenType.LESSOREQUALS, matcher.group(TokenType.LESSOREQUALS.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.GREATER.name()) != null) {

                tokens.add(new Token(TokenType.GREATER, matcher.group(TokenType.GREATER.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.LESS.name()) != null) {

                tokens.add(new Token(TokenType.LESS, matcher.group(TokenType.LESS.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.SEMICOLON.name()) != null) {

                tokens.add(new Token(TokenType.SEMICOLON, matcher.group(TokenType.SEMICOLON.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.SCOPESTART.name()) != null) {

                tokens.add(new Token(TokenType.SCOPESTART, matcher.group(TokenType.SCOPESTART.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.SCOPEEND.name()) != null) {

                tokens.add(new Token(TokenType.SCOPEEND, matcher.group(TokenType.SCOPEEND.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.BRASTART.name()) != null) {

                tokens.add(new Token(TokenType.BRASTART, matcher.group(TokenType.BRASTART.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.BRAEND.name()) != null) {

                tokens.add(new Token(TokenType.BRAEND, matcher.group(TokenType.BRAEND.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.ARRSTART.name()) != null) {

                tokens.add(new Token(TokenType.ARRSTART, matcher.group(TokenType.ARRSTART.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.ARREND.name()) != null) {

                tokens.add(new Token(TokenType.ARREND, matcher.group(TokenType.ARREND.name()), matcher.start()));

                continue;

            } else if (matcher.group(TokenType.COMMENTBLOCK.name()) != null || matcher.group(TokenType.WHITESPACE.name()) != null || matcher.group(TokenType.COMMENTLINE.name()) != null) {

                continue;

            }
        }

        return tokens;
    }

}
