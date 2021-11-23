package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpLineTo extends Op {

    private final double x;
    private final double y;

    public OpLineTo(double x, double y){
        super(OpCode.LineTo);
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
        OpLineTo opLineTo = (OpLineTo) o;
        return Double.compare(opLineTo.x, x) == 0 && Double.compare(opLineTo.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
