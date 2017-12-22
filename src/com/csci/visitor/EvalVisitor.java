package com.csci.visitor;


import com.csci.grammar.*;

public interface EvalVisitor {

    void visit(PDefs pDefs);

    void visit(DFun dFun);

    void visit(SReturn sReturn);

    void visit(SDecls sDecls);

    void visit(ADecl aDecl);

    void visit(SInit sInit);

    void visit(SExp sExp);

    void visit(SIfElse sIfElse);

    void visit(SWhile sWhile);

    void visit(EId eId);

    void visit(EIncr eIncr);

    void visit(EPIncr epIncr);

    void visit(EDecr eDecr);

    void visit(EPDecr epDecr);

    void visit(EInt eInt);

    void visit(ETrue eTrue);

    void visit(EFalse eFalse);

    void visit(EDouble eDouble);

    void visit(EString eString);

    void visit(EEq eEq);

    void visit(ENEq enEq);

    void visit(EGt eGt);

    void visit(EGtEq eGtEq);

    void visit(ELt eLt);

    void visit(ELtEq eLtEq);

    void visit(EAnd eAnd);

    void visit(EOr eOr);

    void visit(EApp eApp);

    void visit(EAss eAss);

    void visit(EPlus ePlus);

    void visit(EMinus eMinus);

    void visit(EDiv eDiv);

    void visit(ETimes eTimes);

    void visit(TypeBool typeBool);

    void visit(TypeInt typeInt);

    void visit(TypeDouble typeDouble);

    void visit(TypeString typeString);

    void visit(TypeVoid typeVoid);

}
