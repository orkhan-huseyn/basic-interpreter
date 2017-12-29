package com.csci.visitor;


import com.csci.grammar.*;

public interface EvalVisitor {

    CustomObject visit(PDefs pDefs) throws Exception;

    CustomObject visit(DFun dFun) throws Exception;

    CustomObject visit(SReturn sReturn) throws Exception;

    CustomObject visit(SDecls sDecls) throws Exception;

    CustomObject visit(ADecl aDecl) throws Exception;

    CustomObject visit(SInit sInit) throws Exception;

    CustomObject visit(SAss sAss) throws Exception;

    CustomObject visit(SExp sExp) throws Exception;

    CustomObject visit(SIfElse sIfElse) throws Exception;

    CustomObject visit(SWhile sWhile) throws Exception;

    CustomObject visit(EId eId) throws Exception;

    CustomObject visit(EIncr eIncr) throws Exception;

    CustomObject visit(EPIncr epIncr) throws Exception;

    CustomObject visit(EDecr eDecr) throws Exception;

    CustomObject visit(EPDecr epDecr) throws Exception;

    CustomObject visit(EInt eInt) throws Exception;

    CustomObject visit(ETrue eTrue) throws Exception;

    CustomObject visit(EFalse eFalse) throws Exception;

    CustomObject visit(EDouble eDouble) throws Exception;

    CustomObject visit(EString eString) throws Exception;

    CustomObject visit(EEq eEq) throws Exception;

    CustomObject visit(ENEq enEq) throws Exception;

    CustomObject visit(EGt eGt) throws Exception;

    CustomObject visit(EGtEq eGtEq) throws Exception;

    CustomObject visit(ELt eLt) throws Exception;

    CustomObject visit(ELtEq eLtEq) throws Exception;

    CustomObject visit(EAnd eAnd) throws Exception;

    CustomObject visit(EOr eOr) throws Exception;

    CustomObject visit(EApp eApp) throws Exception;

    CustomObject visit(EAss eAss) throws Exception;

    CustomObject visit(EPlus ePlus) throws Exception;

    CustomObject visit(EMinus eMinus) throws Exception;

    CustomObject visit(EDiv eDiv) throws Exception;

    CustomObject visit(ETimes eTimes) throws Exception;

    CustomObject visit(TypeBool typeBool) throws Exception;

    CustomObject visit(TypeInt typeInt) throws Exception;

    CustomObject visit(TypeDouble typeDouble) throws Exception;

    CustomObject visit(TypeString typeString) throws Exception;

    CustomObject visit(TypeVoid typeVoid) throws Exception;

}
