package com.enmer.compi2.semantico;

import com.enmer.compi2.DecafOLC2BaseVisitor;
import com.enmer.compi2.DecafOLC2Parser;
import com.enmer.compi2.errors.CompileError;
import com.enmer.compi2.errors.ErrorReporter;

public class SemanticChecker extends DecafOLC2BaseVisitor<Void> {
    private final GlobalScope global;
    private final ErrorReporter reporter;
    private ClassSymbol currentClass;
    private String currentFile = "<sin-archivo>";

    public SemanticChecker(GlobalScope global, ErrorReporter reporter) {
        this.global = global;
        this.reporter = reporter;
    }

    public void setCurrentFile(String currentFile) {
        this.currentFile = currentFile;
    }

    @Override
    public Void visitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx) {
        String name = ctx.IDENT(0).getText();
        currentClass = global.getClass(name);

        if (currentClass.superName != null) {
            if (global.getClass(currentClass.superName) == null) {
                reporter.add(new CompileError(
                        "Semantico",
                        "La superclase '" + currentClass.superName + "' no existe.",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine(),
                        currentFile
                ));
            }
        }

        for (var m : ctx.miembroClase()) {
            visit(m);
        }

        currentClass = null;
        return null;
    }

    @Override
    public Void visitMetodoDecl(DecafOLC2Parser.MetodoDeclContext ctx) {
        String name = ctx.IDENT().getText();

        if (currentClass.methods.containsKey(name)) {
            reporter.add(new CompileError(
                    "Semantico",
                    "No se permite sobrecarga: el método '" + name + "' ya existe en la clase '" + currentClass.name + "'.",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    currentFile
            ));
        } else {
            currentClass.methods.put(name, new MethodSymbol(name));
        }

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
        } else {
            currentClass.methods.put(name, new MethodSymbol(name));
        }
        return null;
    }
}
