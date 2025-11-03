package com.enmer.compi2.semantico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassSymbol {
    public final String name;
    public String superName;
    public final Map<String, MethodSymbol> methods = new HashMap<>();
    public final Map<String, FieldSymbol> fields = new HashMap<>();

    public ClassSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public Map<String, MethodSymbol> getMethods() {
        return methods;
    }

    public Map<String, FieldSymbol> getFields() {
        return fields;
    }
}
