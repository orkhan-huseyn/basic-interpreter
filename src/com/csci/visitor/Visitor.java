package com.csci.visitor;

import com.csci.grammar.Def;
import com.csci.grammar.Exp;
import com.csci.grammar.Program;
import com.csci.grammar.Stm;

public interface Visitor {

    String visit(Def def);

    String visit(Stm stm);

    String visit(Exp exp);

    String visit(Program program);
}
