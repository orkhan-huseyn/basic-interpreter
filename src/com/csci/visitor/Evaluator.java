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
    public Object visit(PDefs pDefs) {

        Object res = null;

        for (Def def : pDefs.listdef_) {
            res = def.eval(this);
        }

        return res;
    }

    @Override
    public Object visit(DFun dFun) {

        Object res = null;

        for (Stm stm : dFun.liststm_) {
            res = stm.eval(this);
        }

        return res;
    }

    @Override
    public Object visit(SReturn sReturn) {
        return sReturn.exp_.eval(this);
    }

    @Override
    public Object visit(SDecls sDecls) {
        return null;
    }

    @Override
    public Object visit(ADecl aDecl) {
        return null;
    }

    @Override
    public Object visit(SInit sInit) {
        String variable = sInit.id_;
        Object value = sInit.exp_.eval(this);
        GLOBAL_SCOPE.put(variable, value);
        return null;
    }

    @Override
    public Object visit(SExp sExp) {
        return null;
    }

    @Override
    public Object visit(SIfElse sIfElse) {
        return null;
    }

    @Override
    public Object visit(SWhile sWhile) {
        return null;
    }

    @Override
    public Object visit(EId eId) {
        if (GLOBAL_SCOPE.containsKey(eId.id_)) {
            return GLOBAL_SCOPE.get(eId.id_);
        }
        System.out.println("Eval error: Variable " + eId.id_ + " does not exist");
        return null;
    }

    @Override
    public Object visit(EIncr eIncr) {
        return null;
    }

    @Override
    public Object visit(EPIncr epIncr) {
        return null;
    }

    @Override
    public Object visit(EDecr eDecr) {
        return null;
    }

    @Override
    public Object visit(EPDecr epDecr) {
        return null;
    }

    @Override
    public Object visit(EInt eInt) {
        return eInt.integer_;
    }

    @Override
    public Object visit(ETrue eTrue) {
        return true;
    }

    @Override
    public Object visit(EFalse eFalse) {
        return false;
    }

    @Override
    public Object visit(EDouble eDouble) {
        return eDouble.double_;
    }

    @Override
    public Object visit(EString eString) {
        return eString.string_;
    }

    @Override
    public Object visit(EEq eEq) {
        return null;
    }

    @Override
    public Object visit(ENEq enEq) {
        return null;
    }

    @Override
    public Object visit(EGt eGt) {
        return null;
    }

    @Override
    public Object visit(EGtEq eGtEq) {
        return null;
    }

    @Override
    public Object visit(ELt eLt) {
        return null;
    }

    @Override
    public Object visit(ELtEq eLtEq) {
        return null;
    }

    @Override
    public Object visit(EAnd eAnd) {
        return null;
    }

    @Override
    public Object visit(EOr eOr) {
        return null;
    }

    @Override
    public Object visit(EApp eApp) {
        return null;
    }

    @Override
    public Object visit(EAss eAss) {
        return null;
    }

    @Override
    public Object visit(EPlus ePlus) {

        Object exp1 = ePlus.exp_1.eval(this);
        Object exp2 = ePlus.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer)exp1;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer)exp2;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        return (Integer)exp1 + (Integer) exp2;
    }

    @Override
    public Object visit(EMinus eMinus) {

        Object exp1 = eMinus.exp_1.eval(this);
        Object exp2 = eMinus.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer)exp1;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer)exp2;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        return (Integer)exp1 - (Integer) exp2;
    }

    @Override
    public Object visit(EDiv eDiv) {

        Object exp1 = eDiv.exp_1.eval(this);
        Object exp2 = eDiv.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer)exp1;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer)exp2;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        return (Integer)exp1 / (Integer) exp2;
    }

    @Override
    public Object visit(ETimes eTimes) {

        Object exp1 = eTimes.exp_1.eval(this);
        Object exp2 = eTimes.exp_2.eval(this);

        if (exp1 instanceof Integer) {
            exp1 = (Integer)exp1;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        if (exp2 instanceof Integer) {
            exp2 = (Integer)exp2;
        } else {
            System.out.println("Invalid type: Integer expected");
        }

        return (Integer)exp1 * (Integer) exp2;
    }

    @Override
    public Object visit(TypeBool typeBool) {
        return null;
    }

    @Override
    public Object visit(TypeInt typeInt) {
        return null;
    }

    @Override
    public Object visit(TypeDouble typeDouble) {
        return null;
    }

    @Override
    public Object visit(TypeString typeString) {
        return null;
    }

    @Override
    public Object visit(TypeVoid typeVoid) {
        return null;
    }
}
