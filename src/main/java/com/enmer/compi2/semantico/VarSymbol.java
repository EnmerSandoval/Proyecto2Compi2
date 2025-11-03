package com.enmer.compi2.semantico;

public class VarSymbol {
    public final String name;
    public final Type type;

    public VarSymbol(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
