package com.csci.components.exps.primitive;

import com.csci.components.exps.Exp;

public class EDouble extends Exp {

    private double value;

    public EDouble(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("[ double: %f ]", this.getValue());
    }
}
