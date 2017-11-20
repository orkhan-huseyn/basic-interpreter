package com.csci.components.exps.primitive;

import com.csci.components.exps.Exp;

public class ETrue extends Exp {

    private boolean booleanTrue;

    public ETrue() {
        this.booleanTrue = true;
    }

    public boolean getBooleanTrue() {
        return booleanTrue;
    }
}
