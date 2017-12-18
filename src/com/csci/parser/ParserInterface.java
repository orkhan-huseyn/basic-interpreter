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
     * Parse definitions (functions)
     *
     * @return Def
     * @throws Exception syntax exception
     */
    Def parseDefinition() throws Exception;

    /**
     * Parse arguments
     *
     * @return Arg
     * @throws Exception syntax exception
     */
    Arg parseArgs() throws Exception;

    /**
     * Parse expression
     *
     * @return Exp
     * @throws Exception syntax exception
     */
    Exp parseExp() throws Exception;

    /**
     * Parse statement
     *
     * @return Stm
     * @throws Exception syntax exception
     */
    Stm parseStm() throws Exception;

    /**
     * Parse type
     *
     * @return Type
     * @throws Exception syntax exception
     */
    Type parseType() throws Exception;

}
