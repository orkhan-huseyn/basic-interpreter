package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class TypeInt extends Type {

    public TypeInt() { }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object eval(EvalVisitor visitor) throws Exception {
        return visitor.visit(this);
    }
}
