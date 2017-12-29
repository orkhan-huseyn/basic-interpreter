package com.csci.visitor;

import com.csci.grammar.*;

import java.util.HashMap;
import java.util.Map;

public class Evaluator implements EvalVisitor {

    public Map<String, CustomObject> GLOBAL_SCOPE;

    public Evaluator() {
        GLOBAL_SCOPE = new HashMap<>();
    }

    @Override
    public CustomObject visit(PDefs pDefs) throws Exception {

        CustomObject res = null;

        for (Def def : pDefs.listdef_) {
            res = def.eval(this);
        }

        return res;
    }

    @Override
    public CustomObject visit(DFun dFun) throws Exception {

        CustomObject res = null;

        for (Stm stm : dFun.liststm_) {
            res = stm.eval(this);
        }

        return res;
    }

    @Override
    public CustomObject visit(SReturn sReturn) throws Exception {
        return sReturn.exp_.eval(this);
    }

    @Override
    public CustomObject visit(SDecls sDecls) throws Exception {
        if (!GLOBAL_SCOPE.containsKey(sDecls.id_)) {
            String variable = sDecls.id_;
            Type type = sDecls.type_;
            GLOBAL_SCOPE.put(variable, new CustomObject(type, null));
        } else {
            throw new Exception("Variable " + sDecls.id_ + " already exist in this scope!");
        }
        return null;
    }

    @Override
    public CustomObject visit(ADecl aDecl) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(SInit sInit) throws Exception {

        if (!GLOBAL_SCOPE.containsKey(sInit.id_)) {

            String variable = sInit.id_;

            CustomObject value = sInit.exp_.eval(this);

            Type type = sInit.type_;

            if (value.type instanceof TypeBool && type instanceof TypeBool) {

            } else if (value.type instanceof TypeInt && type instanceof TypeInt) {

            } else if (value.type instanceof TypeDouble && type instanceof TypeDouble) {

            } else if (value.type instanceof TypeString && type instanceof TypeString) {

            } else {
                throw new Exception("Type error: Trying to assign " + value.type.getClass().getName() + " to " + type.getClass().getName());
            }

            GLOBAL_SCOPE.put(variable, new CustomObject(type, value));

        } else {
            throw new Exception("Variable " + sInit.id_ + " already exist in this scope!");
        }

        return null;

    }

    @Override
    public CustomObject visit(SAss sAss) throws Exception {

        if (GLOBAL_SCOPE.containsKey(sAss.id)) {

            String variable = sAss.id;

            CustomObject value = sAss.exp.eval(this);

            Type type = GLOBAL_SCOPE.get(variable).type;

            if (value.type instanceof TypeBool && type instanceof TypeBool) {

            } else if (value.type instanceof TypeInt && type instanceof TypeInt) {

            } else if (value.type instanceof TypeDouble && type instanceof TypeDouble) {

            } else if (value.type instanceof TypeString && type instanceof TypeString) {

            } else {
                throw new Exception("Type error: Trying to assign " + value.type.getClass().getName() + " to " + type.getClass().getName());
            }

            GLOBAL_SCOPE.put(variable, new CustomObject(type, value));

        } else {
            throw new Exception("Variable " + sAss.id + " has not beed declared in this scope!");
        }

        return null;

    }

    @Override
    public CustomObject visit(SExp sExp) throws Exception {
        return sExp.exp_.eval(this);
    }

    @Override
    public CustomObject visit(SIfElse sIfElse) throws Exception {

        CustomObject condition = sIfElse.exp_.eval(this);

        CustomObject res = null;

        if (!(condition.type instanceof TypeBool))
            throw new Exception("Type error: condition is not boolean");

        if ((Boolean) condition.value) {
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
    public CustomObject visit(SWhile sWhile) throws Exception {

        CustomObject condition = sWhile.exp_.eval(this);

        CustomObject res = null;

        if (!(condition.type instanceof TypeBool))
            throw new Exception("Type error: condition is not boolean");

        if ((Boolean) condition.value) {
            for (Stm stm : sWhile.stm_) {
                res = stm.eval(this);
            }
            sWhile.eval(this);
        }

        return res;
    }

    @Override
    public CustomObject visit(EId eId) throws Exception {

        if (GLOBAL_SCOPE.containsKey(eId.id_) && GLOBAL_SCOPE.get(eId.id_).value != null) {
            return GLOBAL_SCOPE.get(eId.id_);
        } else if (GLOBAL_SCOPE.containsKey(eId.id_) && GLOBAL_SCOPE.get(eId.id_).value == null) {
            throw new Exception("Variable " + eId.id_ + " has never been initialized!");
        } else {
            throw new Exception("Variable " + eId.id_ + " does not exist in this scope!");
        }

    }

    @Override
    public CustomObject visit(EIncr eIncr) throws Exception {

        CustomObject value = eIncr.exp_.eval(this);

        if (value.type instanceof TypeInt) {

            value.value = (Integer) value.value + 1;
            if (eIncr.exp_ instanceof EId) {
                GLOBAL_SCOPE.put(((EId) eIncr.exp_).id_, value);
                return null;
            }
            return value;

        } else {
            throw new Exception("Type error: Integer or Float expected!");
        }
    }

    @Override
    public CustomObject visit(EPIncr epIncr) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EDecr eDecr) throws Exception {
        CustomObject value = eDecr.exp_.eval(this);
        if (value.type instanceof TypeInt) {

            value.value = (Integer) value.value - 1;
            if (eDecr.exp_ instanceof EId) {
                GLOBAL_SCOPE.put(((EId) eDecr.exp_).id_, value);
                return null;
            }
            return value;

        } else {
            throw new Exception("Type error: Integer or Double expected!");
        }
    }

    @Override
    public CustomObject visit(EPDecr epDecr) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EInt eInt) throws Exception {
        return new CustomObject(new TypeInt(), eInt.integer_);
    }

    @Override
    public CustomObject visit(ETrue eTrue) throws Exception {
        return new CustomObject(new TypeBool(), true);
    }

    @Override
    public CustomObject visit(EFalse eFalse) throws Exception {
        return new CustomObject(new TypeBool(), false);
    }

    @Override
    public CustomObject visit(EDouble eDouble) throws Exception {
        return new CustomObject(new TypeDouble(), eDouble.double_);
    }

    @Override
    public CustomObject visit(EString eString) throws Exception {
        return new CustomObject(new TypeString(), eString.string_.replace("\"", ""));
    }

    @Override
    public CustomObject visit(EEq eEq) throws Exception {
        Boolean res = false;
        CustomObject exp1 = eEq.exp_1.eval(this);
        CustomObject exp2 = eEq.exp_2.eval(this);
        if (exp1.type instanceof TypeString && exp2.type instanceof TypeString) {
            res = exp1.value.equals(exp2.value);
        } else {
            res = exp1.value == exp2.value;
        }
        return new CustomObject(new TypeBool(), res);
    }

    @Override
    public CustomObject visit(ENEq enEq) throws Exception {
        Boolean res = enEq.exp_1.eval(this).value != enEq.exp_2.eval(this).value;
        return new CustomObject(new TypeBool(), res);
    }

    @Override
    public CustomObject visit(EGt eGt) throws Exception {
        Boolean res = eGt.exp_1.eval(this).value > eGt.exp_2.eval(this).value;
        return new CustomObject(new TypeBool(), res);
    }

    @Override
    public CustomObject visit(EGtEq eGtEq) throws Exception {
        return (Integer) eGtEq.exp_1.eval(this) >= (Integer) eGtEq.exp_2.eval(this);
    }

    @Override
    public CustomObject visit(ELt eLt) throws Exception {
        return (Integer) eLt.exp_1.eval(this) < (Integer) eLt.exp_2.eval(this);
    }

    @Override
    public CustomObject visit(ELtEq eLtEq) throws Exception {
        return (Integer) eLtEq.exp_1.eval(this) <= (Integer) eLtEq.exp_2.eval(this);
    }

    @Override
    public CustomObject visit(EAnd eAnd) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EOr eOr) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EApp eApp) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EAss eAss) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(EPlus ePlus) throws Exception {

        Object exp1 = ePlus.exp_1.eval(this);
        Object exp2 = ePlus.exp_2.eval(this);

        Object res = null;

        if (exp1 instanceof Integer && exp2 instanceof Integer) {
            res = (Integer) exp1 + (Integer) exp2;
        } else if (exp1 instanceof Double && exp2 instanceof Double) {
            res = (Double) exp1 + (Double) exp2;
        } else if (exp1 instanceof Integer && exp2 instanceof Double) {
            res = (Integer) exp1 + (Double) exp2;
        } else if (exp1 instanceof Double && exp2 instanceof Integer) {
            res = (Double) exp1 + (Integer) exp2;
        } else if (exp1 instanceof String || exp2 instanceof String) {
            res = exp1.toString() + exp2.toString();
        } else {
            throw new Exception(exp1.getClass().getName() + " cannot be added to " + exp1.getClass().getName());
        }

        return res;
    }

    @Override
    public CustomObject visit(EMinus eMinus) throws Exception {

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
    public CustomObject visit(EDiv eDiv) throws Exception {

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
    public CustomObject visit(ETimes eTimes) throws Exception {

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
    public CustomObject visit(TypeBool typeBool) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(TypeInt typeInt) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(TypeDouble typeDouble) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(TypeString typeString) throws Exception {
        return null;
    }

    @Override
    public CustomObject visit(TypeVoid typeVoid) throws Exception {
        return null;
    }
}
