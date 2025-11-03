package com.enmer.compi2.semantico;

public class Type {
    private final Kind kind;
    private final String className;

    public Type(Kind kind, String className) {
        this.kind = kind;
        this.className = className;
    }

    public Type(Kind kind) {
        this.kind = kind;
        this.className = null;
    }

    public Kind getKind() {
        return kind;
    }

    public String getClassName() {
        return className;
    }

    public boolean isClass(){
        return kind == Kind.CLASS;
    }

    @Override
    public String toString() {
        if (kind == Kind.CLASS) {
            return "class " + className;
        }
        return kind.name().toLowerCase();
    }
}
