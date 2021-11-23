package dev.fujiwara.drawer.render;

import dev.fujiwara.drawer.DrawerCompiler;
import dev.fujiwara.drawer.DrawerCompiler.VAlign;

public interface Renderable {
    void render(DrawerCompiler compiler, double x, double y, VAlign valign); // returns horizontal advancement
    double calcWidth(DrawerCompiler compiler);
}
