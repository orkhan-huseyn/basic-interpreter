package com.csci.components.types;

import com.csci.components.Type;
import com.csci.lexer.TokenType;

public class TypeInt extends Type {

    private String value;

    public TypeInt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("INT {value}", this.getValue());
    }
}
