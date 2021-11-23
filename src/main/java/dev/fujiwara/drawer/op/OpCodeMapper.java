package dev.fujiwara.drawer.op;

import java.util.HashMap;
import java.util.Map;

public class OpCodeMapper {

    private Map<String, OpCode> map = new HashMap<>();

    public OpCodeMapper() {
        for (OpCode opCode : OpCode.values()) {
            map.put(opCode.getIdent(), opCode);
        }
    }

    public OpCode map(String ident) {
        return map.get(ident);
    }

}
