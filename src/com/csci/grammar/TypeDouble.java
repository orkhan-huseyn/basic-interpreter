package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class TypeDouble extends Type {

    public TypeDouble() { }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public CustomObject eval(EvalVisitor visitor) throws Exception {
        return visitor.visit(this);
    }
}
