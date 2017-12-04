package com.csci.parser;

import com.csci.lexer.Token;
import com.csci.lexer.TokenType;

import java.util.LinkedList;

public class Parser {

    LinkedList<Token> tokens;
    Token lookahead;

    public void parse(LinkedList<Token> tokens) {

        this.tokens = tokens;
        lookahead = this.tokens.getFirst();

        expression();

    }

    private void expression() {

    }

    private void nextToken() {
        tokens.pop();
        lookahead = tokens.getFirst();
    }
}
