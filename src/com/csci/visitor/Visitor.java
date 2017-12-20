package com.csci.visitor;


import com.csci.grammar.*;

public interface Visitor {

    String visit(PDefs pDefs);

    String visit(DFun dFun);

    String visit(SReturn sReturn);

    String visit(SDecls sDecls);

    String visit(ADecl aDecl);

    String visit(SInit sInit);

    String visit(SExp sExp);

    String visit(SIfElse sIfElse);

    String visit(SWhile sWhile);

    String visit(EId eId);

    String visit(EIncr eIncr);

    String visit(EPIncr epIncr);

    String visit(EDecr eDecr);

    String visit(EPDecr epDecr);

    String visit(EInt eInt);

    String visit(ETrue eTrue);

    String visit(EFalse eFalse);

    String visit(EDouble eDouble);

    String visit(EString eString);

    String visit(EEq eEq);

    String visit(ENEq enEq);

    String visit(EGt eGt);

    String visit(EGtEq eGtEq);

    String visit(ELt eLt);

    String visit(ELtEq eLtEq);

    String visit(EAnd eAnd);

    String visit(EOr eOr);

    String visit(EApp eApp);

    String visit(EAss eAss);

    String visit(EPlus ePlus);

    String visit(EMinus eMinus);

    String visit(EDiv eDiv);

    String visit(ETimes eTimes);

    String visit(TypeBool typeBool);

    String visit(TypeInt typeInt);

    String visit(TypeDouble typeDouble);

    String visit(TypeString typeString);

    String visit(TypeVoid typeVoid);

}
