package com.csci.visitor;


import com.csci.grammar.*;

public interface EvalVisitor {

    Object visit(PDefs pDefs) throws Exception;

    Object visit(DFun dFun) throws Exception;

    Object visit(SReturn sReturn) throws Exception;

    Object visit(SDecls sDecls) throws Exception;

    Object visit(ADecl aDecl) throws Exception;

    Object visit(SInit sInit) throws Exception;

    Object visit(SAss sAss) throws Exception;

    Object visit(SExp sExp) throws Exception;

    Object visit(SIfElse sIfElse) throws Exception;

    Object visit(SWhile sWhile) throws Exception;

    Object visit(EId eId) throws Exception;

    Object visit(EIncr eIncr) throws Exception;

    Object visit(EPIncr epIncr) throws Exception;

    Object visit(EDecr eDecr) throws Exception;

    Object visit(EPDecr epDecr) throws Exception;

    Object visit(EInt eInt) throws Exception;

    Object visit(ETrue eTrue) throws Exception;

    Object visit(EFalse eFalse) throws Exception;

    Object visit(EDouble eDouble) throws Exception;

    Object visit(EString eString) throws Exception;

    Object visit(EEq eEq) throws Exception;

    Object visit(ENEq enEq) throws Exception;

    Object visit(EGt eGt) throws Exception;

    Object visit(EGtEq eGtEq) throws Exception;

    Object visit(ELt eLt) throws Exception;

    Object visit(ELtEq eLtEq) throws Exception;

    Object visit(EAnd eAnd) throws Exception;

    Object visit(EOr eOr) throws Exception;

    Object visit(EApp eApp) throws Exception;

    Object visit(EAss eAss) throws Exception;

    Object visit(EPlus ePlus) throws Exception;

    Object visit(EMinus eMinus) throws Exception;

    Object visit(EDiv eDiv) throws Exception;

    Object visit(ETimes eTimes) throws Exception;

    Object visit(TypeBool typeBool) throws Exception;

    Object visit(TypeInt typeInt) throws Exception;

    Object visit(TypeDouble typeDouble) throws Exception;

    Object visit(TypeString typeString) throws Exception;

    Object visit(TypeVoid typeVoid) throws Exception;

}
