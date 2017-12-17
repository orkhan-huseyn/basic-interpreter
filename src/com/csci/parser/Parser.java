package com.csci.parser;

import com.csci.grammar.*;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;
import java.util.LinkedList;

public class Parser implements ParserInterface {

    LinkedList<Token> tokens;
    Token lookahead;

    public Parser(LinkedList<Token> tokens) {
        this.tokens = tokens;
        lookahead = this.tokens.getFirst();
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

    @Override
    public Program parseProgram() {

        Type typeInt = new TypeInt();

        Def main = new DFun(typeInt, "main", null, null);

        ListDef listDef = new ListDef();
        listDef.add(main);

        return new PDefs(listDef);
    }

    @Override
    public Def parseDefinition() {
        return null;
    }

    @Override
    public Arg parseArgs() {
        return null;
    }

    @Override
    public Exp parseExp() {
        return null;
    }

    @Override
    public Stm parseStm() {
        return null;
    }

    @Override
    public Type parseType() {
        return null;
    }
}
