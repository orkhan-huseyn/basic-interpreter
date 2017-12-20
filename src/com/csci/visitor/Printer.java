package com.csci.visitor;

import com.csci.grammar.*;

public class Printer implements Visitor {


    @Override
    public String visit(PDefs pDefs) {

        StringBuilder builder = new StringBuilder();

        for (Def def : pDefs.listdef_) {
            builder.append(this.visit((DFun) def));
        }

        return builder.toString();
    }

    @Override
    public String visit(DFun dFun) {
        return "FUNCTION";
    }

    @Override
    public String visit(SReturn sReturn) {
        return null;
    }

    @Override
    public String visit(SDecls sDecls) {
        return null;
    }

    @Override
    public String visit(ADecl aDecl) {
        return null;
    }

    @Override
    public String visit(SInit sInit) {
        return null;
    }

    @Override
    public String visit(SExp sExp) {
        return null;
    }

    @Override
    public String visit(SIfElse sIfElse) {
        return null;
    }

    @Override
    public String visit(SWhile sWhile) {
        return null;
    }

    @Override
    public String visit(EId eId) {
        return null;
    }

    @Override
    public String visit(EIncr eIncr) {
        return null;
    }

    @Override
    public String visit(EPIncr epIncr) {
        return null;
    }

    @Override
    public String visit(EDecr eDecr) {
        return null;
    }

    @Override
    public String visit(EPDecr epDecr) {
        return null;
    }

    @Override
    public String visit(EInt eInt) {
        return null;
    }

    @Override
    public String visit(ETrue eTrue) {
        return null;
    }

    @Override
    public String visit(EFalse eFalse) {
        return null;
    }

    @Override
    public String visit(EDouble eDouble) {
        return null;
    }

    @Override
    public String visit(EString eString) {
        return null;
    }

    @Override
    public String visit(EEq eEq) {
        return null;
    }

    @Override
    public String visit(ENEq enEq) {
        return null;
    }

    @Override
    public String visit(EGt eGt) {
        return null;
    }

    @Override
    public String visit(EGtEq eGtEq) {
        return null;
    }

    @Override
    public String visit(ELt eLt) {
        return null;
    }

    @Override
    public String visit(ELtEq eLtEq) {
        return null;
    }

    @Override
    public String visit(EAnd eAnd) {
        return null;
    }

    @Override
    public String visit(EOr eOr) {
        return null;
    }

    @Override
    public String visit(EApp eApp) {
        return null;
    }

    @Override
    public String visit(EAss eAss) {
        return null;
    }

    @Override
    public String visit(EPlus ePlus) {
        return null;
    }

    @Override
    public String visit(EMinus eMinus) {
        return null;
    }

    @Override
    public String visit(EDiv eDiv) {
        return null;
    }

    @Override
    public String visit(ETimes eTimes) {
        return null;
    }

    @Override
    public String visit(TypeBool typeBool) {
        return null;
    }

    @Override
    public String visit(TypeInt typeInt) {
        return null;
    }

    @Override
    public String visit(TypeDouble typeDouble) {
        return null;
    }

    @Override
    public String visit(TypeString typeString) {
        return null;
    }

    @Override
    public String visit(TypeVoid typeVoid) {
        return null;
    }
}
