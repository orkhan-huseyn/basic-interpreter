package com.csci.components;

public class Prog {

    private Def[] definitions;

    public Prog(Def[] definitions) {
        this.definitions = definitions;
    }

    public Def[] getDefinitions() {
        return this.definitions;
    }

    public String toString() {
        return "program";
    }
}
