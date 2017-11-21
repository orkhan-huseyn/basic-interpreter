package com.csci.parser;

import com.csci.components.Arg;
import com.csci.components.Def;
import com.csci.components.Prog;
import com.csci.components.Type;
import com.csci.components.exps.Exp;
import com.csci.components.stms.Stm;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;

import java.util.List;

public class Parser {

    private List<Token> tokens;
    private Token next;
    private int index;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.index = 0;
        this.next = tokens.get(index);
    }

    public Stm parse() {

        Token first  = next;
        Token second = tokens.get(1);

        if (first.getType().equals(TokenType.TYPEINT) && second.getType().equals(TokenType.IDENT)) {
            parseDeclaration();
        }

        return null;
    }

    public Stm parseDeclaration() {

        return null;

    };

    public void nextToken(Token expected) throws Exception {
        if (next.getData().equals(expected.getData())) {
            next();
        }
        else {
            throw new Exception(String.format("Expected %s but got %s", expected.getData(), next.getData()));
        }
    }

    private void next() {
        if (index < tokens.size()) {
            index++;
            next = tokens.get(index);
        }
    }
}
