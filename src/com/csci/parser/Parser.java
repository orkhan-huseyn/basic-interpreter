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
     *
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
     *
     * @param expected expected token
     * @throws Exception syntax exception
     */
    private void expect(TokenType expected) throws Exception {
        nextToken();
        if (lookahead.getType() != expected) {
            throw new Exception(String.format("Parse error: Unexpected token \"%s\" at %d", lookahead.getData(), lookahead.getPosition()));
        }
    }

    /**
     * Parse Program
     *
     * @return Program
     * @throws Exception syntax exception
     */
    @Override
    public Program parseProgram() throws Exception {

        ListDef listDef = new ListDef();

        if (lookahead.getType() == TokenType.TYPEINT) {
            Type typeInt = new TypeInt();
            expect(TokenType.IDENT);
            String functionName = lookahead.getData();
            expect(TokenType.BRASTART);
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            ListStm listStm = parseListStm();
            expect(TokenType.SCOPEEND);
            Def function = new DFun(typeInt, functionName, null, listStm);
            listDef.add(function);
        } else {
            throw new Exception("No function found!");
        }

        return new PDefs(listDef);
    }

    @Override
    public ListDef parseListDef() throws Exception {
        return null;
    }

    @Override
    public ListArg parseListArg() throws Exception {
        return null;
    }

    @Override
    public Exp parseExp() throws Exception {
        return null;
    }

    /**
     * Parse statement list
     *
     * @return ListStm
     * @throws Exception syntax exception
     */
    @Override
    public ListStm parseListStm() throws Exception {

        ListStm listStm = new ListStm();

        if (lookahead.getType() == TokenType.RETURN) {
            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);
            SReturn sReturn = new SReturn(exp);
            listStm.add(sReturn);
        }
        else if (lookahead.getType() == TokenType.IF) {
            expect(TokenType.BRASTART);
            Exp condition = parseExp();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            expect(TokenType.SCOPEEND);
            SIfElse sIfElse = new SIfElse(condition,null, null);
            listStm.add(sIfElse);
        }

        return listStm;
    }
}
