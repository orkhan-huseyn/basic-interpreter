package com.csci.components.stms;

import com.csci.components.exps.Exp;
import com.csci.components.util.Rest;

public class SIfElse extends Stm {

    private Exp exp;
    private Stm stm;
    private Rest rest;

    public SIfElse(Exp exp, Stm stm, Rest rest) {
        this.exp = exp;
        this.stm = stm;
        this.rest = rest;
    }

    public Exp getExp() {
        return exp;
    }

    public Stm getStm() {
        return stm;
    }

    public Rest getRest() {
        return rest;
    }
}
