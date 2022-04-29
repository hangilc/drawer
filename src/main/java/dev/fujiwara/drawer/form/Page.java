package dev.fujiwara.drawer.form;

import dev.fujiwara.drawer.op.Op;

import java.util.List;
import java.util.Map;

public class Page {

    public List<Op> ops;
    public Map<String, Rect> marks;
    public Map<String, String> hints;
    public List<String> descriptions;
    public String name;

}
