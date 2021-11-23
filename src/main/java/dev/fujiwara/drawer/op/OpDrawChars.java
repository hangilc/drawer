package dev.fujiwara.drawer.op;

import java.util.List;
import java.util.Objects;

public class OpDrawChars extends Op {

    private final String chars;
    private final List<Double> xs;
    private final List<Double> ys;

    public OpDrawChars(String chars, List<Double> xs, List<Double> ys){
        super(OpCode.DrawChars);
        this.chars = chars;
        this.xs = xs;
        this.ys = ys;
    }

    public String getChars() {
        return chars;
    }

    public List<Double> getXs() {
        return xs;
    }

    public List<Double> getYs() {
        return ys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpDrawChars that = (OpDrawChars) o;
        return chars.equals(that.chars) && xs.equals(that.xs) && ys.equals(that.ys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chars, xs, ys);
    }
}
