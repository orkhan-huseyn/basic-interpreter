package com.csci.components.exps.primitive;

import com.csci.components.Id;
import com.csci.components.exps.Exp;

public class EId extends Exp {

    private Id id;

    public EId(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }
}
