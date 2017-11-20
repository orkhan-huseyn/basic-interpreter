package com.csci.components.stms;

import java.util.Arrays;

public class SBlock extends Stm {

    private Stm[] stms;

    public SBlock(Stm[] stms) {
        this.stms = stms;
    }

    public Stm[] getStms() {
        return stms;
    }

    @Override
    public String toString() {
        return String.format("[ block_statement: { %s } ]", Arrays.toString(this.getStms()));

    }
}
