package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpCircle extends Op {

    private final double cx;
    private final double cy;
    private final double r;

    public OpCircle(double cx, double cy, double r) {
        super(OpCode.Circle);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getR() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpCircle opCircle = (OpCircle) o;
        return Double.compare(opCircle.cx, cx) == 0 && Double.compare(opCircle.cy, cy) == 0 && Double.compare(opCircle.r, r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cx, cy, r);
    }
}
