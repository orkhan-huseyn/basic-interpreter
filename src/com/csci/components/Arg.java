package com.csci.components;

import com.csci.components.exps.primitive.Id;

public class Arg {

    private Type type;
    private Id id;

    public Arg(Type type, Id id) {
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
        return String.format("[ arg: %s %s ]", this.getType().getValue(), this.getId().getValue());
    }
}
