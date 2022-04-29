package dev.fujiwara.drawer.form;

import dev.fujiwara.drawer.op.Op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Form {

    public String paper;
    public List<Op> setup;
    public List<Page> pages;

    public Form(){
        this.paper = "A4";
        this.setup = Collections.emptyList();
        this.pages = new ArrayList<>();
    }
}
