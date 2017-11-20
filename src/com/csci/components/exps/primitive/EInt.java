package com.csci.components.exps.primitive;

import com.csci.components.exps.Exp;

public class EInt extends Exp {

    private int value;

    public EInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
