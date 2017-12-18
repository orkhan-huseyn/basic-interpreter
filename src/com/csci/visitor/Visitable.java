package com.csci.visitor;

public interface Visitable {

    String accept(Visitor visitor);

}
