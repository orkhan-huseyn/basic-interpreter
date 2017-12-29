package com.csci.visitor;

import com.csci.grammar.CustomObject;

public interface Visitable {

    String accept(PrintVisitor visitor);

    CustomObject eval(EvalVisitor visitor) throws Exception;

}
