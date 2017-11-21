package com.csci.components;

import com.csci.components.exps.primitive.Id;

public class ADecl extends Arg {

    private Type type;
    private Id id;

    public ADecl(Type type, Id id) {
        this.type = type;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public Id getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("[ arg: %s %s ]", "", this.getId().getValue());
    }

}
