package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpSetPen extends Op {

    private final String name;

    public OpSetPen(String name){
        super(OpCode.SetPen);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpSetPen opSetPen = (OpSetPen) o;
        return name.equals(opSetPen.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
