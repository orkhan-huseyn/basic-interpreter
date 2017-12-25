package com.csci.visitor;


import com.csci.grammar.*;

public interface EvalVisitor {

    Object visit(PDefs pDefs);

    Object visit(DFun dFun);

    Object visit(SReturn sReturn);

    Object visit(SDecls sDecls);

    Object visit(ADecl aDecl);

    Object visit(SInit sInit);

    Object visit(SExp sExp);

    Object visit(SIfElse sIfElse);

    Object visit(SWhile sWhile);

    Object visit(EId eId);

    Object visit(EIncr eIncr);

    Object visit(EPIncr epIncr);

    Object visit(EDecr eDecr);

    Object visit(EPDecr epDecr);

    Object visit(EInt eInt);

    Object visit(ETrue eTrue);

    Object visit(EFalse eFalse);

    Object visit(EDouble eDouble);

    Object visit(EString eString);

    Object visit(EEq eEq);

    Object visit(ENEq enEq);

    Object visit(EGt eGt);

    Object visit(EGtEq eGtEq);

    Object visit(ELt eLt);

    Object visit(ELtEq eLtEq);

    Object visit(EAnd eAnd);

    Object visit(EOr eOr);

    Object visit(EApp eApp);

    Object visit(EAss eAss);

    Object visit(EPlus ePlus);

    Object visit(EMinus eMinus);

    Object visit(EDiv eDiv);

    Object visit(ETimes eTimes);

    Object visit(TypeBool typeBool);

    Object visit(TypeInt typeInt);

    Object visit(TypeDouble typeDouble);

    Object visit(TypeString typeString);

    Object visit(TypeVoid typeVoid);

}
