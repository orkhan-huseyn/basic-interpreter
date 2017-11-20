package com.csci.components.exps.primitive;

public class EFalse {

    private boolean booleanFalse;

    public EFalse() {
        this.booleanFalse = false;
    }

    public boolean getBooleanFalse() {
        return booleanFalse;
    }

    @Override
    public String toString() {
        return String.format("[ boolean: %b ]", this.getBooleanFalse());
    }
}
