package com.csci.parser;

import com.csci.components.DFun;
import com.csci.components.Prog;
import com.csci.components.exps.primitive.EInt;
import com.csci.components.exps.primitive.Id;
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

        try {
            if (lookahead.getType() == TokenType.TYPEINT) {
                expect(TokenType.IDENT);
                Id id = new Id(lookahead.getData());
                expect(TokenType.BRASTART);
                expect(TokenType.BRAEND);
                expect(TokenType.SCOPESTART);
                TypeInt typeInt = new TypeInt(lookahead.getData());
                expect(TokenType.SCOPEEND);
                return new DFun(typeInt, id, null, null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

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
