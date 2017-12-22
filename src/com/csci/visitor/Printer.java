package com.csci.visitor;

import com.csci.grammar.*;

public class Printer implements Visitor {

    @Override
    public String visit(PDefs pDefs) {

        StringBuilder builder = new StringBuilder();

        for (Def def : pDefs.listdef_) {
            builder.append(def.accept(this));
        }

        return builder.toString();
    }


    @Override
    public String visit(DFun dFun) {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("DFun (%s) => ", dFun.id_));

        for (Stm stm : dFun.liststm_) {
            builder.append(stm.accept(this));
        }

        return builder.toString();
    }

    @Override
    public String visit(SReturn sReturn) {

        StringBuilder builder = new StringBuilder();

        builder.append("SReturn => ");
        builder.append(sReturn.exp_.accept(this));

        return builder.toString();
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

        StringBuilder builder = new StringBuilder();

        builder.append("SInit => ");
        builder.append(sInit.id_);
        builder.append(sInit.exp_.accept(this));

        return builder.toString();
    }

    @Override
    public String visit(SExp sExp) {

        return "SExp => " + sExp.exp_.accept(this);
    }

    @Override
    public String visit(SIfElse sIfElse) {

        StringBuilder builder = new StringBuilder();

        builder.append("SIfElse => ");
        builder.append(sIfElse.exp_.accept(this));
        for (Stm stm : sIfElse.stm_1) {
            builder.append(stm.accept(this));
        }
        for (Stm stm : sIfElse.stm_2) {
            builder.append(stm.accept(this));
        }

        return builder.toString();
    }

    @Override
    public String visit(SWhile sWhile) {
        return null;
    }

    @Override
    public String visit(EId eId) {
        return "EId => " + eId.id_;
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
        return "EInt => " + eInt.integer_.toString();
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
        return "EDouble => " + eDouble.double_.toString();
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

        StringBuilder builder = new StringBuilder();

        builder.append("EPlus => ");
        builder.append(ePlus.exp_1.accept(this));
        builder.append(ePlus.exp_2.accept(this));

        return builder.toString();
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
        return "int";
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
