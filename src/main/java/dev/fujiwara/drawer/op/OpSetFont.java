package dev.fujiwara.drawer.op;

public class OpSetFont extends Op {

    private final String name;

    public OpSetFont(String name){
        super(OpCode.SetFont);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
