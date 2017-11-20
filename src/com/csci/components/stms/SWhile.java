package com.csci.components.stms;

import com.csci.components.exps.Exp;

public class SWhile extends  Stm {

    private Exp exp;
    private Stm stm;

    public SWhile(Exp exp, Stm stm) {
        this.exp = exp;
        this.stm = stm;
    }

    public Stm getStm() {
        return stm;
    }

    public Exp getExp() {
        return exp;
    }
}
