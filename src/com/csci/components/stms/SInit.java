package com.csci.components.stms;

import com.csci.components.Type;
import com.csci.components.exps.primitive.Id;
import com.csci.components.exps.Exp;

public class SInit extends Stm {

    private Type type;
    private Id id;
    private Exp exp;

    public SInit(Type type, Id id, Exp exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public Type getType() {
        return type;
    }

    public Id getId() {
        return id;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return String.format("[ initialization: %s %s = %s; ]", "", this.getId().getValue(), this.getExp().toString());
    }
}
