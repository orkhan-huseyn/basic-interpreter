package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class TypeString extends Type {

    public TypeString() {
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
