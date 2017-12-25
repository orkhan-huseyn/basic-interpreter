package com.csci.visitor;

import com.csci.grammar.*;

import java.util.HashMap;
import java.util.Map;

public class Evaluator implements EvalVisitor {

    public Map<String, Object> GLOBAL_SCOPE;

    public Evaluator() {
        GLOBAL_SCOPE = new HashMap<>();
    }

    @Override
    public Object visit(PDefs pDefs) throws Exception {

        Object res = null;

        for (Def def : pDefs.listdef_) {
            res = def.eval(this);
        }

        return res;
    }

    @Override
    public Object visit(DFun dFun) throws Exception {

        Object res = null;

        for (Stm stm : dFun.liststm_) {
            res = stm.eval(this);
        }

        return res;
    }

    @Override
    public Object visit(SReturn sReturn) throws Exception {
        return sReturn.exp_.eval(this);
    }

    @Override
    public Object visit(SDecls sDecls) throws Exception {
        return null;
    }

    @Override
    public Object visit(ADecl aDecl) throws Exception {
        return null;
    }

    @Override
    public Object visit(SInit sInit) throws Exception {

        if (!GLOBAL_SCOPE.containsKey(sInit.id_)) {
            String variable = sInit.id_;
            Object value = sInit.exp_.eval(this);
            GLOBAL_SCOPE.put(variable, value);
        } else {
            throw new Exception("Variable " + sInit.id_ + " already exist in this scope!");
        }

        return null;

    }

    @Override
    public Object visit(SExp sExp) throws Exception {
        return null;
    }

    @Override
    public Object visit(SIfElse sIfElse) throws Exception {
        return null;
    }

    @Override
    public Object visit(SWhile sWhile) throws Exception {
        return null;
    }

    @Override
    public Object visit(EId eId) throws Exception {

        if (GLOBAL_SCOPE.containsKey(eId.id_)) {
            return GLOBAL_SCOPE.get(eId.id_);
        } else {
            throw new Exception("Variable " + eId.id_ + " does not exist in this scope!");
        }

    }

    @Override
    public Object visit(EIncr eIncr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EPIncr epIncr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EDecr eDecr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EPDecr epDecr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EInt eInt) throws Exception {
        return eInt.integer_;
    }

    @Override
    public Object visit(ETrue eTrue) throws Exception {
        return true;
    }

    @Override
    public Object visit(EFalse eFalse) throws Exception {
        return false;
    }

    @Override
    public Object visit(EDouble eDouble) throws Exception {
        return eDouble.double_;
    }

    @Override
    public Object visit(EString eString) throws Exception {
        return eString.string_;
    }

    @Override
    public Object visit(EEq eEq) throws Exception {
        return null;
    }

    @Override
    public Object visit(ENEq enEq) throws Exception {
        return null;
    }

    @Override
    public Object visit(EGt eGt) throws Exception {
        return null;
    }

    @Override
    public Object visit(EGtEq eGtEq) throws Exception {
        return null;
    }

    @Override
    public Object visit(ELt eLt) throws Exception {
        return null;
    }

    @Override
    public Object visit(ELtEq eLtEq) throws Exception {
        return null;
    }

    @Override
    public Object visit(EAnd eAnd) throws Exception {
        return null;
    }

    @Override
    public Object visit(EOr eOr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EApp eApp) throws Exception {
        return null;
    }

    @Override
    public Object visit(EAss eAss) throws Exception {
        return null;
    }

    @Override
    public Object visit(EPlus ePlus) throws Exception {

        Object exp1 = ePlus.exp_1.eval(this);
        Object exp2 = ePlus.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer) exp1;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer) exp2;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 + (Integer) exp2;
    }

    @Override
    public Object visit(EMinus eMinus) throws Exception {

        Object exp1 = eMinus.exp_1.eval(this);
        Object exp2 = eMinus.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer) exp1;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer) exp2;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 - (Integer) exp2;
    }

    @Override
    public Object visit(EDiv eDiv) throws Exception {

        Object exp1 = eDiv.exp_1.eval(this);
        Object exp2 = eDiv.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer) exp1;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer) exp2;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 / (Integer) exp2;
    }

    @Override
    public Object visit(ETimes eTimes) throws Exception {

        Object exp1 = eTimes.exp_1.eval(this);
        Object exp2 = eTimes.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer) exp1;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer) exp2;
        } else {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 * (Integer) exp2;
    }

    @Override
    public Object visit(TypeBool typeBool) throws Exception {
        return null;
    }

    @Override
    public Object visit(TypeInt typeInt) throws Exception {
        return null;
    }

    @Override
    public Object visit(TypeDouble typeDouble) throws Exception {
        return null;
    }

    @Override
    public Object visit(TypeString typeString) throws Exception {
        return null;
    }

    @Override
    public Object visit(TypeVoid typeVoid) throws Exception {
        return null;
    }
}
