package com.csci.parser;

import com.csci.grammar.*;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;
import java.util.LinkedList;

public class Parser implements ParserInterface {

    /**
     * Token list
     */
    private LinkedList<Token> tokens;
    /**
     * lookahead token
     */
    private Token lookahead;

    /**
     * Parser constructor
     * @param tokens token list
     */
    public Parser(LinkedList<Token> tokens) {
        this.tokens = tokens;
        lookahead = this.tokens.getFirst();
    }

    /**
     * change lookahead to the next token
     */
    private void nextToken() {
        tokens.pop();
        lookahead = tokens.getFirst();
    }

    /**
     * Check expected token
     * @param expected expected token
     * @throws Exception syntax exception
     */
    private void expect(TokenType expected) throws Exception {
        nextToken();
        if (lookahead.getType() != expected) {
            throw new Exception("Parse error: Expected token: " + expected.name() + " but got " + lookahead.getType().name());
        }
    }

    /**
     * Parse Program
     * @return Program
     * @throws Exception syntax exception
     */
    @Override
    public Program parseProgram() throws Exception {

        ListDef listDef = new ListDef();

        if (lookahead.getType() == TokenType.TYPEINT) {
            Type typeInt = new TypeInt();
            expect(TokenType.MAIN);
            String functionName = lookahead.getData();
            expect(TokenType.BRASTART);
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            expect(TokenType.SCOPEEND);
            Def function = new DFun(typeInt, functionName, null, null);
            listDef.add(function);
        } else {
            throw new Exception("No main function found!");
        }

        return new PDefs(listDef);
    }

    @Override
    public Def parseDefinition() throws Exception {
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
