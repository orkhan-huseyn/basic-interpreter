package com.csci.components.stms;

import com.csci.components.exps.Exp;

public class SExp extends Stm {

    private Exp exp;

    public SExp(Exp exp) {
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    public String toString() {
        return String.format("statement: %s", this.getExp().toString());
    }
}
