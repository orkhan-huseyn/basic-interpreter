package com.csci.visitor;

public interface Visitable {

    String accept(PrintVisitor visitor);

    Object eval(EvalVisitor visitor) throws Exception;

}
