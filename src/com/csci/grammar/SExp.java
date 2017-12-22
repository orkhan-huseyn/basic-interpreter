package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class SExp extends Stm {

    public Exp exp_;

    public SExp(Exp p1) {
        exp_ = p1;
    }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public void eval(EvalVisitor visitor) {
        visitor.visit(this);
    }

}
