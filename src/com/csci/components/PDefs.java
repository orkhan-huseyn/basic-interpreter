package com.csci.components;

public class PDefs extends Prog {

    private Def[] definitions;

    public PDefs(Def[] definitions) {
        this.definitions = definitions;
    }

    public Def[] getDefinitions() {
        return this.definitions;
    }

    public String toString() {
        return "[ program ]";
    }

}
