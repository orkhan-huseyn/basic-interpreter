package com.csci.components.exps.primitive;

import com.csci.components.exps.Exp;

public class EInt extends Exp {

    private String value;

    public EInt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("[ integer: %s ]", this.getValue());
    }
}
