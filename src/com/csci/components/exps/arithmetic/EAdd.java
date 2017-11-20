package com.csci.components.exps.arithmetic;

import com.csci.components.exps.Exp;

public class EAdd extends Exp {

    private Exp exp1;
    private Exp exp2;

    public EAdd(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public Exp getExp1() {
        return exp1;
    }

    public Exp getExp2() {
        return exp2;
    }

    @Override
    public String toString() {
        return String.format("[ addition: %s + %s ]", this.getExp1().toString(), this.getExp2().toString());
    }
}
