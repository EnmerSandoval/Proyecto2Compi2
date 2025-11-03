package com.enmer.compi2.semantico;

import com.enmer.compi2.DecafOLC2BaseVisitor;
import com.enmer.compi2.DecafOLC2Parser;
import com.enmer.compi2.errors.CompileError;
import com.enmer.compi2.errors.ErrorReporter;

public class MemberCollector extends DecafOLC2BaseVisitor<Void> {
    private final GlobalScope global;
    private final ErrorReporter reporter;
    private ClassSymbol currentClass;
    private String currentFile = "<sin-archivo>";

    public MemberCollector(GlobalScope global, ErrorReporter reporter) {
        this.global = global;
        this.reporter = reporter;
    }

    public void setCurrentFile(String file) {
        this.currentFile = file;
    }

    @Override
    public Void visitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx) {
        String name = ctx.IDENT(0).getText();
        currentClass = global.getClass(name);

        for (var m : ctx.miembroClase()) {
            visit(m);
        }

        currentClass = null;
        return null;
    }

    @Override
    public Void visitCampoDecl(DecafOLC2Parser.CampoDeclContext ctx) {
        if (ctx.tipo() != null) {
            Type t = resolveType(ctx.tipo());
            for (var v : ctx.listaVars().varInit()) {
                String varName = v.IDENT().getText();
                if (currentClass.fields.containsKey(varName)) {
                    reporter.add(new CompileError(
                            "Semantico",
                            "Campo '" + varName + "' ya existe en la clase '" + currentClass.name + "'.",
                            ctx.start.getLine(),
                            ctx.start.getCharPositionInLine(),
                            currentFile
                    ));
                } else {
                    currentClass.fields.put(varName, new FieldSymbol(varName, t));
                }
            }
        } else {
            String varName = ctx.IDENT().getText();
            currentClass.fields.put(varName, new FieldSymbol(varName, new Type(Kind.ERROR)));
        }
        return null;
    }

    @Override
    public Void visitMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx) {
        String name = ctx.IDENT().getText();
        Type ret = (ctx.tipo() != null) ? resolveType(ctx.tipo()) : new Type(Kind.VOID);

        if (currentClass.methods.containsKey(name)) {
            reporter.add(new CompileError(
                    "Semantico",
                    "No se permite sobrecarga: método '" + name + "' repetido en clase '" + currentClass.name + "'.",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    currentFile
            ));
            return null;
        }

        MethodSymbol ms = new MethodSymbol(name, ret);

        if (ctx.params() != null) {
            for (var p : ctx.params().param()) {
                String pName = p.IDENT().getText();
                Type pType = resolveType(p.tipo());
                ms.params.add(new VarSymbol(pName, pType));
            }
        }

        currentClass.methods.put(name, ms);
        return null;
    }

    @Override
    public Void visitConstructorDecl(DecafOLC2Parser.ConstructorDeclContext ctx) {
        String name = ctx.IDENT().getText();

        if (currentClass.methods.containsKey(name)) {
            reporter.add(new CompileError(
                    "Semantico",
                    "No se permite más de un constructor en la clase '" + currentClass.name + "'.",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    currentFile
            ));
            return null;
        }

        MethodSymbol ctor = new MethodSymbol(name, new Type(Kind.VOID));

        if (ctx.params() != null) {
            for (var p : ctx.params().param()) {
                String pName = p.IDENT().getText();
                Type pType = resolveType(p.tipo());
                ctor.params.add(new VarSymbol(pName, pType));
            }
        }

        currentClass.methods.put(name, ctor);
        return null;
    }

    private Type resolveType(DecafOLC2Parser.TipoContext ctx) {
        String txt = ctx.tipoBase().getText();
        return switch (txt) {
            case "int"     -> new Type(Kind.INT);
            case "float"   -> new Type(Kind.FLOAT);
            case "char"    -> new Type(Kind.CHAR);
            case "boolean" -> new Type(Kind.BOOLEAN);
            case "String"  -> new Type(Kind.STRING);
            default        -> new Type(Kind.CLASS, txt);
        };
    }
}
