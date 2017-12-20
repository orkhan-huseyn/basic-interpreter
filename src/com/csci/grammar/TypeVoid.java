package com.csci.grammar;

import com.csci.visitor.Visitor;

public class TypeVoid extends Type {

    public TypeVoid() {
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
