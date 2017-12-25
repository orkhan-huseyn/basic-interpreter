package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class SWhile extends Stm {

    public Exp exp_;
    public ListStm stm_;

    public SWhile(Exp p1, ListStm p2) {
        exp_ = p1;
        stm_ = p2;
    }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object eval(EvalVisitor visitor) throws Exception {
        return visitor.visit(this);
    }
}
