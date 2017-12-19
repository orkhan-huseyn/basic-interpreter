package com.csci.visitor;

import com.csci.grammar.*;

public class Evaluator implements Visitor {

    @Override
    public String visit(PDefs pDefs) {
        return null;
    }

    @Override
    public String visit(DFun dFun) {
        return null;
    }

    @Override
    public String visit(SReturn sReturn) {
        return null;
    }

    @Override
    public String visit(EInt eInt) {
        return null;
    }

    @Override
    public String visit(EPlus ePlus) {
        return null;
    }
}
