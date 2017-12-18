package com.csci.parser;

import com.csci.grammar.*;
import com.csci.lexer.Token;
import com.csci.lexer.TokenType;

import java.util.LinkedList;

public class Parser implements ParserInterface {

    /**
     * Token list
     */
    private LinkedList<Token> tokenList;

    /**
     * lookahead token
     */
    private Token lookahead;

    /**
     * Parser constructor
     *
     * @param tokenList token list
     */
    public Parser(LinkedList<Token> tokenList) {
        this.tokenList = tokenList;
        lookahead = this.tokenList.getFirst();
    }

    /**
     * Change lookahead to the next token
     */
    private void nextToken() {
        tokenList.pop();
        lookahead = tokenList.getFirst();
    }

    /**
     * Check expected token
     *
     * @param expected token to eat
     * @throws Exception syntax exception
     */
    private void expect(TokenType expected) throws Exception {
        nextToken();
        if (lookahead.getType() != expected || tokenList.isEmpty()) {
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
        ListDef listDef = parseListDef();
        return new PDefs(listDef);
    }

    /**
     * Parse definition list
     *
     * @return ListDef
     * @throws Exception syntax exception
     */
    @Override
    public ListDef parseListDef() throws Exception {

        ListDef listDef = new ListDef();

        if (lookahead.getType() == TokenType.TYPEINT && tokenList.get(2).getType() == TokenType.SCOPESTART) {

            Type typeInt = new TypeInt();
            expect(TokenType.IDENT);
            String functionName = lookahead.getData();
            expect(TokenType.BRASTART);
            ListArg listArg = parseListArg();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            ListStm listStm = parseListStm();
            expect(TokenType.SCOPEEND);
            Def function = new DFun(typeInt, functionName, listArg, listStm);
            listDef.add(function);

        } else if (lookahead.getType() == TokenType.TYPEBOOL && tokenList.get(2).getType() == TokenType.SCOPESTART) {

            Type typeBool = new TypeBool();
            expect(TokenType.IDENT);
            String functionName = lookahead.getData();
            expect(TokenType.BRASTART);
            ListArg listArg = parseListArg();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            ListStm listStm = parseListStm();
            expect(TokenType.SCOPEEND);
            Def function = new DFun(typeBool, functionName, listArg, listStm);
            listDef.add(function);

        }

        return listDef;
    }

    /**
     * Parse single definition
     *
     * @return Def
     * @throws Exception syntax exception
     */
    public Def parseDFun() throws Exception {
        return null;
    }

    /**
     * Parse argument list
     *
     * @return ListArg
     * @throws Exception syntax exception
     */
    @Override
    public ListArg parseListArg() throws Exception {
        return null;
    }


    /**
     * Parse single argument
     *
     * @return Arg
     * @throws Exception syntax exception
     */
    public Arg parseArg() throws Exception {
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

    /**
     * Parse single statement
     *
     * @return ListStm
     * @throws Exception syntax exception
     */
    public Stm parseStm() throws Exception {
        return null;
    }
}
