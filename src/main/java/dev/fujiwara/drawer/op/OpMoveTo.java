package dev.fujiwara.drawer.op;

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

}
