package com.csci.parser;

import com.csci.components.Prog;
import com.csci.components.types.TypeInt;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;

import java.util.LinkedList;

public class Parser {

    LinkedList<Token> tokens;
    Token lookahead;

    public Prog parse(LinkedList<Token> tokens) {

        this.tokens = tokens;
        lookahead = this.tokens.getFirst();

        if (lookahead.getType() == TokenType.INT) {
            return new TypeInt(lookahead.getData());
        }

        return null;
    }

    private void nextToken() {
        tokens.pop();
        lookahead = tokens.getFirst();
    }

    private void expect(Token token, Token expected) throws Exception {
        if (token.getType() == expected.getType()) {
            nextToken();
        } else {
            throw new Exception("Parse error");
        }
    }
}
