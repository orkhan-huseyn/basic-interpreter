package com.csci.parser;

import com.csci.grammar.*;

public interface ParserInterface {

    /**
     * Parse program
     *
     * @return program
     * @throws Exception syntax exception
     */
    Program parseProgram() throws Exception;

    /**
     * Parse definition list
     *
     * @return ListDef
     * @throws Exception syntax exception
     */
    ListDef parseListDef() throws Exception;

    /**
     * Parse single definition
     *
     * @return Def
     * @throws Exception syntax exception
     */
    Def parseDef() throws Exception;

    /**
     * Parse argument list
     *
     * @return ListArg
     * @throws Exception syntax exception
     */
    ListArg parseListArg() throws Exception;

    /**
     * Parse single argument
     *
     * @return Arg
     * @throws Exception syntax exception
     */
    Arg parseArg() throws Exception;

    /**
     * Parse expression
     *
     * @return Exp
     * @throws Exception syntax exception
     */
    Exp parseExp() throws Exception;

    /**
     * Parse statement list
     *
     * @return ListStm
     * @throws Exception syntax exception
     */
    ListStm parseListStm() throws Exception;

    /**
     * Parse single statement
     *
     * @return ListStm
     * @throws Exception syntax exception
     */
    Stm parseStm() throws Exception;

}
