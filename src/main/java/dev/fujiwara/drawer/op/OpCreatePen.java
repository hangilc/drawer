package dev.fujiwara.drawer.op;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OpCreatePen extends Op {

    private final String name;
    private final int r;
    private final int g;
    private final int b;
    private final double width;
    private final List<Double> penStyle;

    public OpCreatePen(String name, int r, int g, int b, double width, List<Double> penStyle){
        super(OpCode.CreatePen);
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
        this.width = width;
        this.penStyle = penStyle;
   }

    public OpCreatePen(String name, int r, int g, int b, double width){
        this(name, r, g, b, width, Collections.emptyList());
    }

    public String getName() {
        return name;
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

    public double getWidth() {
        return width;
    }

    public List<Double> getPenStyle() {
        return penStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpCreatePen that = (OpCreatePen) o;
        return r == that.r && g == that.g && b == that.b && Double.compare(that.width, width) == 0 && name.equals(that.name) && penStyle.equals(that.penStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, r, g, b, width, penStyle);
    }
}
