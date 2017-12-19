package com.csci.visitor;

import com.csci.grammar.*;

public class Printer implements Visitor {

    @Override
    public String visit(PDefs pDefs) {
        return "PDefs";
    }

    @Override
    public String visit(DFun dFun) {
        return "DFun";
    }

    @Override
    public String visit(SReturn sReturn) {
        return "SReturn";
    }

    @Override
    public String visit(EInt eInt) {
        return "EInt";
    }

    @Override
    public String visit(EPlus ePlus) {
        return "EPlus";
    }
}
