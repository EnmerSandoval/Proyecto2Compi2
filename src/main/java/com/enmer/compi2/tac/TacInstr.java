package com.enmer.compi2.tac;

public class TacInstr {
    private final String op;
    private final String arg1;
    private final String arg2;
    private final String result;

    public TacInstr(String op, String arg1, String arg2, String result) {
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    public String getop() {
        return op;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        if (op.equals("label")) {
            return result + ":";
        }
        if (op.equals("goto")) {
            return "goto " + result;
        }
        if (op.startsWith("if")) {
            return op + " " + arg1 + ", " + arg2 + " goto " + result;
        }
        if (op.equals("assign")) {
            return result + " = " + arg1;
        }
        return result + " = " + arg1 + " " + op + " " + arg2;
    }

}
