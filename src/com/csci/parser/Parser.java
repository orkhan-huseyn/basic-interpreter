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

        Def def = parseDef();

        if (def != null) {
            listDef.add(def);
            listDef.addAll(parseListDef());
        }

        return listDef;
    }

    /**
     * Parse single definition
     *
     * @return Def
     * @throws Exception syntax exception
     */
    public Def parseDef() throws Exception {

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

            return new DFun(typeInt, functionName, listArg, listStm);

        }

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

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.PLUS)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EPlus(eDouble, exp);

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.MINUS)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EMinus(eDouble, exp);

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.DIV)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new EDiv(eDouble, exp);

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.PROD)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            Exp exp = parseExp();
            return new ETimes(eDouble, exp);

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.INCREMENT)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            return new EIncr(eDouble);

        } else if (lookahead.is(TokenType.FLOAT) && lookahead(1).is(TokenType.DECREMENT)) {

            EDouble eDouble = new EDouble(Double.parseDouble(lookahead.getData()));
            nextToken();
            return new EDecr(eDouble);

        } else if (lookahead.is(TokenType.FLOAT)) {

            return new EDouble(Double.parseDouble(lookahead.getData()));

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

        ListStm listStm = new ListStm();

        Stm stm = parseStm();

        if (stm != null) {
            listStm.add(stm);
            listStm.addAll(parseListStm());
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

        nextToken();

        if (lookahead.is(TokenType.RETURN)) {

            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);

            return new SReturn(exp);

        } else if (lookahead.is(TokenType.IF)) {

            expect(TokenType.BRASTART);
            Exp condition = parseExp();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            ListStm stmIf = parseListStm();
            expect(TokenType.SCOPEEND);
            expect(TokenType.ELSE);
            expect(TokenType.SCOPESTART);
            ListStm stmElse = parseListStm();
            expect(TokenType.SCOPEEND);

            return new SIfElse(condition, stmIf, stmElse);

        } else if (lookahead.is(TokenType.WHILE)) {

            expect(TokenType.BRASTART);
            Exp condition = parseExp();
            expect(TokenType.BRAEND);
            expect(TokenType.SCOPESTART);
            ListStm stmts = parseListStm();
            expect(TokenType.SCOPEEND);

            return new SWhile(condition, stmts);


        } else if (lookahead.is(TokenType.TYPEINT) && lookahead(1).is(TokenType.IDENT)) {

            TypeInt typeInt = new TypeInt();
            nextToken();
            String varName = lookahead.getData();
            expect(TokenType.ASSIGNMENT);
            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);

            return new SInit(typeInt, varName, exp);


        } else if (lookahead.is(TokenType.TYPEBOOL) && lookahead(1).is(TokenType.IDENT)) {

            TypeBool typeBool = new TypeBool();
            nextToken();
            String varName = lookahead.getData();
            expect(TokenType.ASSIGNMENT);
            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);

            return new SInit(typeBool, varName, exp);


        } else if (lookahead.is(TokenType.TYPEFLOAT) && lookahead(1).is(TokenType.IDENT)) {

            TypeDouble typeDouble = new TypeDouble();
            nextToken();
            String varName = lookahead.getData();
            expect(TokenType.ASSIGNMENT);
            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);

            return new SInit(typeDouble, varName, exp);


        } else if (lookahead.is(TokenType.TYPESTRING) && lookahead(1).is(TokenType.IDENT)) {

            TypeString typeString = new TypeString();
            nextToken();
            String varName = lookahead.getData();
            expect(TokenType.ASSIGNMENT);
            Exp exp = parseExp();
            expect(TokenType.SEMICOLON);

            return new SInit(typeString, varName, exp);

        } else if (lookahead.is(TokenType.IDENT)) {

            String varName = lookahead.getData();

            return new SExp(new EId(varName));

        }

        return null;
    }
}
