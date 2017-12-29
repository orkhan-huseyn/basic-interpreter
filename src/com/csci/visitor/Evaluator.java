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
        if (!GLOBAL_SCOPE.containsKey(sDecls.id_)) {
            String variable = sDecls.id_;
            GLOBAL_SCOPE.put(variable, null);
        } else {
            throw new Exception("Variable " + sDecls.id_ + " already exist in this scope!");
        }
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
    public Object visit(SAss sAss) throws Exception {

        if (GLOBAL_SCOPE.containsKey(sAss.id)) {

            String variable = sAss.id;
            Object value = sAss.exp.eval(this);
            GLOBAL_SCOPE.put(variable, value);

        } else {
            throw new Exception("Variable " + sAss.id + " has not beed declared in this scope!");
        }

        return null;

    }

    @Override
    public Object visit(SExp sExp) throws Exception {
        return sExp.exp_.eval(this);
    }

    @Override
    public Object visit(SIfElse sIfElse) throws Exception {
        Object condition = sIfElse.exp_.eval(this);
        Object res = null;
        if ((Boolean) condition) {
            for (Stm stm : sIfElse.stm_1) {
                res = stm.eval(this);
            }
        } else {
            for (Stm stm : sIfElse.stm_2) {
                res = stm.eval(this);
            }
        }
        return res;
    }

    @Override
    public Object visit(SWhile sWhile) throws Exception {
        Object condition = sWhile.exp_.eval(this);
        Object res = null;
        if ((Boolean) condition) {
            for (Stm stm : sWhile.stm_) {
                res = stm.eval(this);
            }
            sWhile.eval(this);
        }

        return res;
    }

    @Override
    public Object visit(EId eId) throws Exception {

        if (GLOBAL_SCOPE.containsKey(eId.id_) && GLOBAL_SCOPE.get(eId.id_) != null) {
            return GLOBAL_SCOPE.get(eId.id_);
        } else if (GLOBAL_SCOPE.containsKey(eId.id_) && GLOBAL_SCOPE.get(eId.id_) == null) {
            throw new Exception("Variable " + eId.id_ + " has never been initialized!");
        } else {
            throw new Exception("Variable " + eId.id_ + " does not exist in this scope!");
        }

    }

    @Override
    public Object visit(EIncr eIncr) throws Exception {
        Object value = eIncr.exp_.eval(this);
        if (!(value instanceof Integer)) {
            throw new Exception("Type error: Integer expected!");
        }
        value = (Integer)value + 1;
        if (eIncr.exp_ instanceof EId) {
            GLOBAL_SCOPE.put(((EId) eIncr.exp_).id_, value);
            return null;
        }
        return value;
    }

    @Override
    public Object visit(EPIncr epIncr) throws Exception {
        return null;
    }

    @Override
    public Object visit(EDecr eDecr) throws Exception {
        Object value = eDecr.exp_.eval(this);
        if (!(value instanceof Integer)) {
            throw new Exception("Type error: Integer expected!");
        }
        value = (Integer)value - 1;
        if (eDecr.exp_ instanceof EId) {
            GLOBAL_SCOPE.put(((EId) eDecr.exp_).id_, value);
            return null;
        }
        return value;
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
        return eString.string_.replace("\"", "");
    }

    @Override
    public Object visit(EEq eEq) throws Exception {
        Boolean res = false;
        Object exp1 = eEq.exp_1.eval(this);
        Object exp2 = eEq.exp_2.eval(this);
        if (exp1 instanceof  String && exp2 instanceof String) {
            res = exp1.equals(exp2);
        } else {
            res = exp1 == exp2;
        }
        return res;
    }

    @Override
    public Object visit(ENEq enEq) throws Exception {
        return enEq.exp_1.eval(this) != enEq.exp_2.eval(this);
    }

    @Override
    public Object visit(EGt eGt) throws Exception {
        return (Integer) eGt.exp_1.eval(this) > (Integer) eGt.exp_2.eval(this);
    }

    @Override
    public Object visit(EGtEq eGtEq) throws Exception {
        return (Integer) eGtEq.exp_1.eval(this) >= (Integer) eGtEq.exp_2.eval(this);
    }

    @Override
    public Object visit(ELt eLt) throws Exception {
        return (Integer) eLt.exp_1.eval(this) < (Integer) eLt.exp_2.eval(this);
    }

    @Override
    public Object visit(ELtEq eLtEq) throws Exception {
        return (Integer) eLtEq.exp_1.eval(this) <= (Integer) eLtEq.exp_2.eval(this);
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

        Object res = null;

        if (exp1 instanceof Integer && exp2 instanceof Integer) {
            res = (Integer)exp1 + (Integer)exp2;
        } else if (exp1 instanceof Double && exp2 instanceof Double) {
            res = (Double)exp1 + (Double)exp2;
        } else if (exp1 instanceof Integer && exp2 instanceof Double) {
            res = (Integer)exp1 + (Double) exp2;
        }else if (exp1 instanceof Double && exp2 instanceof Integer) {
            res = (Double)exp1 + (Integer) exp2;
        }else if (exp1 instanceof String || exp2 instanceof String) {
            res = exp1.toString() + exp2.toString();
        } else {
            throw new Exception(exp1.getClass().getName() + " cannot be added to " + exp1.getClass().getName());
        }

        return res;
    }

    @Override
    public Object visit(EMinus eMinus) throws Exception {

        Object exp1 = eMinus.exp_1.eval(this);
        Object exp2 = eMinus.exp_2.eval(this);

        if (!(exp1 instanceof Integer)) {
            throw new Exception("Type error: Integer expected");
        }

        if (!(exp2 instanceof Integer)) {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 - (Integer) exp2;
    }

    @Override
    public Object visit(EDiv eDiv) throws Exception {

        Object exp1 = eDiv.exp_1.eval(this);
        Object exp2 = eDiv.exp_2.eval(this);

        if (!(exp1 instanceof Integer)) {
            throw new Exception("Type error: Integer expected");
        }

        if (!(exp2 instanceof Integer)) {
            throw new Exception("Type error: Integer expected");
        }

        return (Integer) exp1 / (Integer) exp2;
    }

    @Override
    public Object visit(ETimes eTimes) throws Exception {

        Object exp1 = eTimes.exp_1.eval(this);
        Object exp2 = eTimes.exp_2.eval(this);

        if (!(exp1 instanceof Integer)) {
            throw new Exception("Type error: Integer expected");
        }

        if (!(exp2 instanceof Integer)) {
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
