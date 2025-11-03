package com.enmer.compi2.semantico;

import com.enmer.compi2.DecafOLC2BaseVisitor;
import com.enmer.compi2.DecafOLC2Parser;
import com.enmer.compi2.errors.CompileError;
import com.enmer.compi2.errors.ErrorReporter;

public class SymbolCollector extends DecafOLC2BaseVisitor<Void> {

    private final GlobalScope global;
    private final ErrorReporter reporter;
    private String currentFile = "<sin-archivo>";

    public SymbolCollector(GlobalScope global, ErrorReporter reporter) {
        this.global = global;
        this.reporter = reporter;
    }

    public GlobalScope getGlobal() {
        return global;
    }

    public ErrorReporter getReporter() {
        return reporter;
    }

    @Override
    public Void visitPrograma(DecafOLC2Parser.ProgramaContext ctx) {
        for (var c : ctx.claseDecl()) {
            visit(c);
        }
        return null;
    }

    @Override
    public Void visitClaseDecl(DecafOLC2Parser.ClaseDeclContext ctx) {
        String name = ctx.IDENT(0).getText();
        ClassSymbol cls = new ClassSymbol(name);

        if (ctx.IDENT().size() > 1) {
            cls.superName = ctx.IDENT(1).getText();
        }

        boolean ok = global.addClass(cls);
        if (!ok) {
            reporter.add(new CompileError(
                    "Semantico",
                    "La clase '" + name + "' ya fue declarada.",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    currentFile
            ));
        }

        return null;
    }
}
