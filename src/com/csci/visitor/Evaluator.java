package com.csci.visitor;

import com.csci.grammar.*;

import java.util.HashMap;
import java.util.Map;

public class Evaluator implements EvalVisitor {

    Map<String, String> GLOBAL_SCOPE;

    public Evaluator() {
        GLOBAL_SCOPE = new HashMap<>();
    }

    @Override
    public void visit(PDefs pDefs) {
        for (Def def : pDefs.listdef_) {
            def.eval(this);
        }
    }

    @Override
    public void visit(DFun dFun) {
        for (Stm stm : dFun.liststm_) {
            stm.eval(this);
        }
    }

    @Override
    public void visit(SReturn sReturn) {

    }

    @Override
    public void visit(SDecls sDecls) {

    }

    @Override
    public void visit(ADecl aDecl) {

    }

    @Override
    public void visit(SInit sInit) {

    }

    @Override
    public void visit(SExp sExp) {

    }

    @Override
    public void visit(SIfElse sIfElse) {

    }

    @Override
    public void visit(SWhile sWhile) {

    }

    @Override
    public void visit(EId eId) {

    }

    @Override
    public void visit(EIncr eIncr) {

    }

    @Override
    public void visit(EPIncr epIncr) {

    }

    @Override
    public void visit(EDecr eDecr) {

    }

    @Override
    public void visit(EPDecr epDecr) {

    }

    @Override
    public void visit(EInt eInt) {

    }

    @Override
    public void visit(ETrue eTrue) {

    }

    @Override
    public void visit(EFalse eFalse) {

    }

    @Override
    public void visit(EDouble eDouble) {

    }

    @Override
    public void visit(EString eString) {

    }

    @Override
    public void visit(EEq eEq) {

    }

    @Override
    public void visit(ENEq enEq) {

    }

    @Override
    public void visit(EGt eGt) {

    }

    @Override
    public void visit(EGtEq eGtEq) {

    }

    @Override
    public void visit(ELt eLt) {

    }

    @Override
    public void visit(ELtEq eLtEq) {

    }

    @Override
    public void visit(EAnd eAnd) {

    }

    @Override
    public void visit(EOr eOr) {

    }

    @Override
    public void visit(EApp eApp) {

    }

    @Override
    public void visit(EAss eAss) {

    }

    @Override
    public void visit(EPlus ePlus) {

    }

    @Override
    public void visit(EMinus eMinus) {

    }

    @Override
    public void visit(EDiv eDiv) {

    }

    @Override
    public void visit(ETimes eTimes) {

    }

    @Override
    public void visit(TypeBool typeBool) {

    }

    @Override
    public void visit(TypeInt typeInt) {

    }

    @Override
    public void visit(TypeDouble typeDouble) {

    }

    @Override
    public void visit(TypeString typeString) {

    }

    @Override
    public void visit(TypeVoid typeVoid) {

    }
}
