package com.csci.components.stms;

import com.csci.components.Id;
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
}
