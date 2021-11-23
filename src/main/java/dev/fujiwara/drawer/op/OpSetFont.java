package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpSetFont extends Op {

    private final String name;

    public OpSetFont(String name){
        super(OpCode.SetFont);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpSetFont opSetFont = (OpSetFont) o;
        return name.equals(opSetFont.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
