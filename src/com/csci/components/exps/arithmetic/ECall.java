package com.csci.components.exps.arithmetic;

import com.csci.components.Id;
import com.csci.components.exps.Exp;

public class ECall extends Exp {

    private Id id;
    private Exp[] exps;

    public ECall(Id id, Exp[] exps) {
        this.id = id;
        this.exps = exps;
    }

    public Id getId() {
        return id;
    }

    public Exp[] getExps() {
        return exps;
    }
}
