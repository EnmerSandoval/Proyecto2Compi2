package com.enmer.compi2.semantico;

import java.util.Objects;

public class Type {
    private final Kind kind;
    private final String className;

    public Type(Kind kind, String className) {
        this.kind = kind;
        this.className = className;
    }

    public Type(Kind kind) {
        this(kind, null);
    }

    public Kind getKind() { return kind; }
    public String getClassName() { return className; }
    public boolean isClass() { return kind == Kind.CLASS; }

    @Override
    public String toString() {
        if (kind == Kind.CLASS) return "class " + className;
        return kind.name().toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type other = (Type) o;
        if (this.kind != other.kind) return false;
        if (this.kind == Kind.CLASS) {
            return Objects.equals(this.className, other.className);
        }
        return true; // primitivos/void/error: basta el kind
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, className);
    }

    public static boolean same(Type a, Type b) { return Objects.equals(a, b); }
    public static boolean both(Kind k, Type a, Type b) {
        return a != null && b != null && a.getKind() == k && b.getKind() == k;
    }
}
