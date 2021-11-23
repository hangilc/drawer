package dev.fujiwara.drawer.op;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import dev.fujiwara.drawer.DrawerConsts;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonTests {

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Op.class, new JacksonOpSerializer());
        module.addDeserializer(Op.class, new JacksonOpDeserializer());
        mapper.registerModule(module);
        return mapper;
    }
    private final static ObjectMapper mapper = createMapper();

    @Test
    public void jsonCodecTest() throws JsonProcessingException {
        List<Op> ops = List.of(
                new OpMoveTo(10, 10),
                new OpLineTo(200, 10),
                new OpLineTo(200, 20),
                new OpCreateFont("default", "sans-serif", 20, DrawerConsts.FontWeightBold, false),
                new OpSetFont("default"),
                new OpDrawChars("こんにちは世界", List.of(10.0), List.of(30.0)),
                new OpSetTextColor(255, 165, 0),
                new OpCreatePen("solid", 10, 20, 255, 0.1),
                new OpCreatePen("broken", 10, 20, 255, 0.1, List.of(2.0, 0.5)),
                new OpSetPen("solid"),
                new OpCircle(100, 130, 30)
        );
        String json = mapper.writeValueAsString(ops);
        List<Op> decoded = mapper.readValue(json, new TypeReference<List<Op>>() {
        });
        assertEquals(ops, decoded);
    }

}
