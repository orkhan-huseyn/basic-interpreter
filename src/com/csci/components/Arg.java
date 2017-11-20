package com.csci.components;

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
}
