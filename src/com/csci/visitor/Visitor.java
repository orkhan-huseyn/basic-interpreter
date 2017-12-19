package com.csci.visitor;


import com.csci.grammar.*;

public interface Visitor {

    String visit(PDefs pDefs);

    String visit(DFun dFun);

    String visit(SReturn sReturn);

    String visit(EInt eInt);

    String visit(EPlus ePlus);

}
