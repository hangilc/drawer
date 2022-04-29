package dev.fujiwara.drawer.drawerform2;

import dev.fujiwara.drawer.Box;
import dev.fujiwara.drawer.DrawerCompiler;
import static dev.fujiwara.drawer.DrawerCompiler.VAlign;

public class MultiLabel implements Multi {

    private final String text;
    private String font = null;

    public MultiLabel(String text) {
        this.text = text;
    }

    @Override
    public Box render(FormCompiler c, Box box, VAlign valign) {
        if( font != null ){
            c.pushFont();
            c.setFont(font);
        }
        Box b = c.textIn(text, box, DrawerCompiler.HAlign.Left, valign);
        if( font != null ){
            c.popFont();
        }
        return b;
    }

    public MultiLabel font(String font){
        this.font = font;
        return this;
    }
}
