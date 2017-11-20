package com.csci.components;

import com.csci.components.exps.Exp;

public class Id extends Exp {

    private String value;

    public Id(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
