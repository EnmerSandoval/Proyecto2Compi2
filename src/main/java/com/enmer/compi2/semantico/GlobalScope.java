package com.enmer.compi2.semantico;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GlobalScope {
    private final Map<String, ClassSymbol> classes = new HashMap<>();

    public boolean addClass(ClassSymbol cls) {
        if(classes.containsKey(cls.getName())){
            return false;
        }
        classes.put(cls.getName(), cls);
        return true;
    }

    public ClassSymbol getClass(String name) {
        return classes.get(name);
    }

    public Collection<ClassSymbol> getAll(){
        return classes.values();
    }
}
