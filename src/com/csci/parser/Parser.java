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
     * Pop and get first token
     */
    private void nextToken() {
        tokenList.pop();
        lookahead = tokenList.getFirst();
    }

    /**
     * @param index token index
     * @return token at index
     */
    private Token lookahead(Integer index) {
        return tokenList.get(index);
    }

    /**
     * Check expected token
     *
     * @param expected token to eat
     * @throws Exception syntax exception
     */
    private void expect(TokenType expected) throws Exception {
        tokenList.pop();
        if (tokenList.isEmpty()) {
            throw new Exception(String.format("Parse error: %s expected", expected.name()));
        } else {
            lookahead = tokenList.getFirst();
            if (lookahead.getType() != expected) {
                throw new Exception(
                        String.format(
                                "Parse error: Unexpected token \"%s\" at position %d. %s expected.",
                                lookahead.getData(),
                                lookahead.getPosition(),
                                expected.name()
                        )
                );
            }
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

        System.out.println(lookahead);

        if (lookahead.is(TokenType.TYPEINT)) {

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

        } else {

            throw new Exception("Parse error: Function expected!");

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

    /**
     * Parse expression
     *
     * @return Exp
     * @throws Exception syntax exception
     */
    @Override
    public Exp parseExp() throws Exception {

        nextToken();

        if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.PLUS)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EPlus(eInt, exp);

        } else if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.MINUS)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EMinus(eInt, exp);

        } else if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.DIV)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EDiv(eInt, exp);

        } else if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.PROD)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new ETimes(eInt, exp);

        } else if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.INCREMENT)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            return new EIncr(eInt);

        } else if (lookahead.is(TokenType.INT) && lookahead(1).is(TokenType.DECREMENT)) {

            EInt eInt = new EInt(Integer.parseInt(lookahead.getData()));
            nextToken();
            return new EDecr(eInt);

        } else if (lookahead.is(TokenType.INT)) {

            return new EInt(Integer.parseInt(lookahead.getData()));

        } else {

            throw new Exception("Parse error: Expression expected!");

        }
    }

    /**
     * Parse statement list
     *
     * @return ListStm
     * @throws Exception syntax exception
     */
    @Override
    public ListStm parseListStm() throws Exception {

        nextToken();

        ListStm listStm = new ListStm();

        if (lookahead.is(TokenType.RETURN)) {

            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);
            SReturn sReturn = new SReturn(exp);
            listStm.add(sReturn);

        } else if (lookahead.is(TokenType.IF)) {

            expect(TokenType.BRASTART);
            Exp condition = parseExp();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            Stm stmIf = parseStm();
            expect(TokenType.SCOPEEND);
            expect(TokenType.ELSE);
            expect(TokenType.SCOPESTART);
            Stm stmElse = parseStm();
            expect(TokenType.SCOPEEND);
            SIfElse sIfElse = new SIfElse(condition, stmIf, stmElse);
            listStm.add(sIfElse);

        } else {

            throw new Exception("Parse error: Statement expected!");

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
