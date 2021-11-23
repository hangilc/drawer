package dev.fujiwara.drawer.op;

public class OpSetPen extends Op {

    private final String name;

    public OpSetPen(String name){
        super(OpCode.SetPen);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
