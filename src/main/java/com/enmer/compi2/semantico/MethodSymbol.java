package com.enmer.compi2.semantico;

import java.util.ArrayList;
import java.util.List;

public class MethodSymbol {
    public final String name;
    public final Type returnType;
    public final List<VarSymbol> params = new ArrayList<>();

    public MethodSymbol(String name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public MethodSymbol(String name) {
        this.name = name;
        this.returnType = null;
    }
}
