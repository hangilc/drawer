package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpSetTextColor extends Op {

    private final int r;
    private final int g;
    private final int b;

    public OpSetTextColor(int r, int g, int b){
        super(OpCode.SetTextColor);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpSetTextColor that = (OpSetTextColor) o;
        return r == that.r && g == that.g && b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }
}
