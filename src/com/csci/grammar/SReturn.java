package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.Visitable;
import com.csci.visitor.PrintVisitor;

public class SReturn extends Stm implements Visitable {

    public Exp exp_;

    public SReturn(Exp p1) {
        exp_ = p1;
    }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object eval(EvalVisitor visitor) {
        return visitor.visit(this);
    }
}
