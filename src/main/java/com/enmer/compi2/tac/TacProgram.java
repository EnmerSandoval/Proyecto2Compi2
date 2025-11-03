package com.enmer.compi2.tac;

import java.util.ArrayList;
import java.util.List;

public class TacProgram {
    private final List<TacInstr> instrs = new ArrayList<>();

    public void add(TacInstr instr) {
        instrs.add(instr);
    }

    public List<TacInstr> getInstrs() {
        return instrs;
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        for (TacInstr instr : instrs) {
            sb.append(instr.toString()).append("\n");
        }
        return sb.toString();
    }

}
