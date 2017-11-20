package com.csci.components.stms;

public class SBlock extends Stm {

    private Stm[] stms;

    public SBlock(Stm[] stms) {
        this.stms = stms;
    }

    public Stm[] getStms() {
        return stms;
    }
}
