package com.csci.grammar;

import com.csci.visitor.EvalVisitor;
import com.csci.visitor.PrintVisitor;

public class DFun extends Def {

    public Type type_;
    public String id_;
    public ListArg listarg_;
    public ListStm liststm_;

    public DFun(Type p1, String p2, ListArg p3, ListStm p4) {
        type_ = p1;
        id_ = p2;
        listarg_ = p3;
        liststm_ = p4;
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
