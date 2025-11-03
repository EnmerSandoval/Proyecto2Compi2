package com.enmer.compi2.semantico;

import com.enmer.compi2.DecafOLC2BaseVisitor;
import com.enmer.compi2.DecafOLC2Parser;
import com.enmer.compi2.errors.CompileError;
import com.enmer.compi2.errors.ErrorReporter;

import java.util.Objects;

public class TypeResolver extends DecafOLC2BaseVisitor<Void> {
    private final GlobalScope global;
    private final ErrorReporter reporter;
    private ClassSymbol currentClass;
    private String currentFile = "<sin-archivo>";

    public TypeResolver(GlobalScope global, ErrorReporter reporter) {
        this.global = global;
        this.reporter = reporter;
    }

    public void setCurrentFile(String file) { this.currentFile = file; }

    @Override
    public Void visitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx) {
        String name = ctx.IDENT(0).getText();
        currentClass = global.getClass(name);

        if (ctx.IDENT().size() > 1) {
            String superName = ctx.IDENT(1).getText();
            if (global.getClass(superName) == null) {
                addErr(ctx, "La superclase '" + superName + "' no existe.");
            } else if (name.equals(superName)) {
                addErr(ctx, "Herencia cíclica directa en '" + name + "'.");
            }
        }

        for (var f : currentClass.getFields().values()) {
            if (f.type.getKind() == Kind.CLASS) {
                String cn = f.type.getClassName();
                if (cn == null || global.getClass(cn) == null) {
                    addErr(ctx, "El campo '" + f.name + "' referencia clase inexistente '" + cn + "'.");
                }
            }
            if (f.type.getKind() == Kind.ERROR) {
                addErr(ctx, "El campo '" + f.name + "' tiene tipo inválido.");
            }
        }

        for (var m : ctx.miembroClase()) visit(m);

        currentClass = null;
        return null;
    }

    @Override
    public Void visitMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx) {
        String name = ctx.IDENT().getText();

        Type declaredRet = (ctx.tipo() != null) ? resolveType(ctx.tipo()) : new Type(Kind.VOID);

        MethodSymbol sym = currentClass.getMethods().get(name);
        if (sym == null) {
            reporter.add(new CompileError(
                    "Semantico",
                    "Símbolo del método '" + name + "' no encontrado. Ejecuta MemberCollector antes de TypeResolver.",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile
            ));
            return null;
        }

        if (!Objects.equals(sym.returnType, declaredRet)) {
            reporter.add(new CompileError("Semantico",
                    "Tipo de retorno inconsistente en '" + name + "': declarado " + declaredRet +
                            " vs símbolo " + sym.returnType + ".",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
        }
        if (declaredRet.getKind() == Kind.CLASS) {
            String cn = declaredRet.getClassName();
            if (cn == null || global.getClass(cn) == null) {
                reporter.add(new CompileError("Semantico",
                        "Retorno de '" + name + "' referencia clase inexistente '" + cn + "'.",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
            }
        }

        int nCtx = (ctx.params() == null) ? 0 : ctx.params().param().size();
        if (nCtx != sym.params.size()) {
            reporter.add(new CompileError("Semantico",
                    "Cantidad de parámetros difiere en '" + name + "': AST=" + nCtx +
                            " vs símbolo=" + sym.params.size() + ".",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
        }
        int limit = Math.min(nCtx, sym.params.size());
        for (int i = 0; i < limit; i++) {
            var pctx = ctx.params().param(i);
            Type pDeclared = resolveType(pctx.tipo());
            VarSymbol pSym = sym.params.get(i);

            if (!Objects.equals(pDeclared, pSym.type)) {
                reporter.add(new CompileError("Semantico",
                        "Tipo del parámetro " + (i+1) + " en '" + name + "': declarado " + pDeclared +
                                " vs símbolo " + pSym.type + ".",
                        pctx.start.getLine(), pctx.start.getCharPositionInLine(), currentFile));
            }
            if (pDeclared.getKind() == Kind.CLASS) {
                String cn = pDeclared.getClassName();
                if (cn == null || global.getClass(cn) == null) {
                    reporter.add(new CompileError("Semantico",
                            "Parámetro " + (i+1) + " ('" + pSym.name + "') de '" + name +
                                    "' referencia clase inexistente '" + cn + "'.",
                            pctx.start.getLine(), pctx.start.getCharPositionInLine(), currentFile));
                }
            }
        }

        String superName = currentClass.getSuperName();
        while (superName != null) {
            ClassSymbol sup = global.getClass(superName);
            if (sup == null) break;
            MethodSymbol up = sup.getMethods().get(name);
            if (up != null) {
                if (!sameSignature(up, sym)) {
                    reporter.add(new CompileError("Semantico",
                            "Override inválido de '" + name + "' en '" + currentClass.getName() +
                                    "'. La firma debe coincidir exactamente con la de la superclase.",
                            ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
                }
                break;
            }
            superName = sup.getSuperName();
        }

        return null;
    }

    @Override
    public Void visitConstructorDecl(DecafOLC2Parser.ConstructorDeclContext ctx) {
        String ctorName = ctx.IDENT().getText();
        if (!currentClass.getName().equals(ctorName)) {
            reporter.add(new CompileError("Semantico",
                    "El constructor debe llamarse igual que la clase: '" + currentClass.getName() + "'.",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
        }
        return null;
    }

    private boolean sameSignature(MethodSymbol a, MethodSymbol b) {
        if (!Objects.equals(a.returnType, b.returnType)) return false;
        if (a.params.size() != b.params.size()) return false;
        for (int i = 0; i < a.params.size(); i++) {
            if (!Objects.equals(a.params.get(i).type, b.params.get(i).type)) return false;
        }
        return true;
    }

    private Type resolveType(DecafOLC2Parser.TipoContext ctx) {
        String txt = ctx.tipoBase().getText();
        switch (txt) {
            case "int":     return new Type(Kind.INT);
            case "float":   return new Type(Kind.FLOAT);
            case "char":    return new Type(Kind.CHAR);
            case "boolean": return new Type(Kind.BOOLEAN);
            case "String":  return new Type(Kind.STRING);
            default:
                return (global.getClass(txt) == null) ? new Type(Kind.ERROR) : new Type(Kind.CLASS, txt);
        }
    }

    private void addErr(DecafOLC2Parser.ClaseDeclContext ctx, String msg) {
        reporter.add(new CompileError("Semantico", msg,
                ctx.start.getLine(), ctx.start.getCharPositionInLine(), currentFile));
    }

}
