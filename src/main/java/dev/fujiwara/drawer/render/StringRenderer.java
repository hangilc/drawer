package dev.fujiwara.drawer.render;

import dev.fujiwara.drawer.DrawerCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.fujiwara.drawer.DrawerCompiler.HAlign;
import static dev.fujiwara.drawer.DrawerCompiler.VAlign;

public class StringRenderer implements Renderable {

    private static Logger logger = LoggerFactory.getLogger(StringRenderer.class);
    private String string;

    public StringRenderer(String string) {
        this.string = string;
    }

    @Override
    public void render(DrawerCompiler compiler, double x, double y, VAlign valign) {
        compiler.textAt(string, x, y, HAlign.Left, valign);
    }

    @Override
    public double calcWidth(DrawerCompiler compiler) {
        return compiler.calcTextWidth(string);
    }
}
