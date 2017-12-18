package com.csci.visitor;

import com.csci.grammar.Def;
import com.csci.grammar.Exp;
import com.csci.grammar.Program;
import com.csci.grammar.Stm;

public class VisitorImpl implements Visitor {

    @Override
    public String visit(Def def) {
        return null;
    }

    @Override
    public String visit(Stm stm) {
        return null;
    }

    @Override
    public String visit(Exp exp) {
        return null;
    }

    @Override
    public String visit(Program program) {
        return null;
    }
}
