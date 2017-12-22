package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class EPDecr extends Exp {

    public Exp exp_;

    public EPDecr(Exp p1) {
        exp_ = p1;
    }

    @Override
    public String accept(PrintVisitor visitor) {
        return null;
    }

    @Override
    public void eval(EvalVisitor visitor) {
        visitor.visit(this);
    }
}
