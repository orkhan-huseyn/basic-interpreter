package com.csci.components.util;

import com.csci.components.stms.Stm;

public class RElse extends Rest {

    private Stm stm;

    public RElse(Stm stm) {
        this.stm = stm;
    }

    public Stm getStm() {
        return stm;
    }
}
