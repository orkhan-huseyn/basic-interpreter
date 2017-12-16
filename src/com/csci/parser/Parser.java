package com.csci.parser;


import com.csci.lexer.Token;
import com.csci.lexer.TokenType;
import java.util.LinkedList;

public class Parser {

    LinkedList<Token> tokens;
    Token lookahead;

    public String parse(LinkedList<Token> tokens) {

        this.tokens = tokens;
        lookahead = this.tokens.getFirst();

        return null;
    }

    private void nextToken() {
        tokens.pop();
        lookahead = tokens.getFirst();
    }

    private void expect(TokenType expected) throws Exception {
        nextToken();
        if (lookahead.getType() != expected) {
            throw new Exception("Parse error");
        }
    }
}
