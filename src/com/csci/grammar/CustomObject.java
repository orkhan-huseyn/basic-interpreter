package com.csci.grammar;

public class CustomObject {

    public Type type;

    public Object value;

    public CustomObject(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
