package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class SDecls extends Stm {

    public Type type_;
    public String id_;

    public SDecls(Type p1, String p2) {
        type_ = p1;
        id_ = p2;
    }

    @Override
    public String accept(PrintVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public CustomObject eval(EvalVisitor visitor) throws Exception {
        return visitor.visit(this);
    }
}
