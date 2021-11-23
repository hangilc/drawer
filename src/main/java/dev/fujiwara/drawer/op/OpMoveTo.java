package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpMoveTo extends Op {

    private final double x;
    private final double y;

    public OpMoveTo(double x, double y){
        super(OpCode.MoveTo);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpMoveTo opMoveTo = (OpMoveTo) o;
        return Double.compare(opMoveTo.x, x) == 0 && Double.compare(opMoveTo.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
