package com.csci.components.stms;

import com.csci.components.exps.primitive.Id;
import com.csci.components.Type;

public class SDecl extends Stm {

    private Type type;
    private Id id;

    public SDecl(Type type, Id id) {
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
        return String.format("[ declaration: %s %s; ]", this.getType().getValue(), this.getId().getValue());
    }
}
