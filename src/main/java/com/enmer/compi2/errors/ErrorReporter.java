package com.enmer.compi2.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    private final List<CompileError> errors = new ArrayList<>();

    public void add(CompileError error) {
        errors.add(error);
    }

    public void clear(){
        errors.clear();
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public List<CompileError> getErrors(){
        return errors;
    }
}
