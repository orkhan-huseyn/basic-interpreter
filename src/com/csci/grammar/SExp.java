package com.csci.grammar;

import com.csci.visitor.Visitor;

public class SExp extends Stm {

    public Exp exp_;

    public SExp(Exp p1) {
        exp_ = p1;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
