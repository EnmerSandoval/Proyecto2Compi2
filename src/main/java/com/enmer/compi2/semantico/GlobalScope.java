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

    public boolean hasClass(String name) {
        return classes.containsKey(name);
    }

    public boolean isSubclassOf(String sub, String sup) {
        if (sub == null || sup == null || sub.equals(sup)) return false;
        ClassSymbol c = classes.get(sub);
        while (c != null && c.getSuperName() != null) {
            if (c.getSuperName().equals(sup)) return true;
            c = classes.get(c.getSuperName());
        }
        return false;
    }

    public String detectInheritanceCycle(String start) {
        String slow = start, fast = start;
        while (true) {
            fast = step(step(fast));
            slow = step(slow);
            if (fast == null || slow == null) return null;
            if (fast.equals(slow)) return slow; // ciclo
        }
    }
    private String step(String name) {
        if (name == null) return null;
        ClassSymbol c = classes.get(name);
        return (c == null) ? null : c.getSuperName();
    }

}
