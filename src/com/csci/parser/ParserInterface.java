package com.csci.parser;

import com.csci.grammar.*;

public interface ParserInterface {

    public Program parseProgram();

    public Def parseDefinition();

    public Arg parseArgs();

    public Exp parseExp();

    public Stm parseStm();

    public Type parseType();

}
