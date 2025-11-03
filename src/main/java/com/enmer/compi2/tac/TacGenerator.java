package com.enmer.compi2.tac;

import com.enmer.compi2.DecafOLC2BaseVisitor;
import com.enmer.compi2.DecafOLC2Parser;

public class TacGenerator extends DecafOLC2BaseVisitor<String> {

    private final TacProgram prog = new TacProgram();
    private int tempCounter = 0;
    private int labelCounter = 0;

    private String newTemp(){
        return "t" + (++tempCounter);
    }

    private String newLabel(String base){
        return base + "_" + (++labelCounter);
    }

    public TacProgram getProgram(){
        return prog;
    }

    @Override
    public String visitLiteral(DecafOLC2Parser.LiteralContext ctx) {
        String t = newTemp();
        prog.add(new TacInstr("assign", ctx.getText(), null, t));
        return t;
    }

    @Override
    public String visitAditivoExpr(DecafOLC2Parser.AditivoExprContext ctx) {
        String left = visit(ctx.multExpr(0));
        for (int i = 1; i < ctx.multExpr().size(); i++) {
            String right = visit(ctx.multExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();
            String t = newTemp();
            prog.add(new TacInstr(op.equals("+") ? "add" : "sub", left, right, t));
            left = t;
        }
        return left;
    }

    @Override
    public String visitIfStmt(DecafOLC2Parser.IfStmtContext ctx) {
        String cond = visit(ctx.expr());
        String lTrue = newLabel("if_true");
        String lEnd  = newLabel("if_end");

        prog.add(new TacInstr("if!=", cond, "0", lTrue));
        prog.add(new TacInstr("goto", null, null, lEnd));

        prog.add(new TacInstr("label", null, null, lTrue));
        visit(ctx.sentencia(0));

        prog.add(new TacInstr("label", null, null, lEnd));
        return null;
    }

}
