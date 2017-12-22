package com.csci.visitor;

public interface Visitable {

    String accept(PrintVisitor visitor);

    void eval(EvalVisitor visitor);

}
