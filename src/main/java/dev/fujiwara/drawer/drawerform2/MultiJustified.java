package dev.fujiwara.drawer.drawerform2;

import dev.fujiwara.drawer.Box;
import static dev.fujiwara.drawer.Box.HorizAnchor;
import dev.fujiwara.drawer.DrawerCompiler;

public class MultiJustified implements Multi {

    private String text;
    private Double width = null;

    public MultiJustified(String text, Double width) {
        this.text = text;
        this.width = width;
    }

    @Override
    public Box render(FormCompiler c, Box box, DrawerCompiler.VAlign valign) {
        if( width != null ){
            box = box.setWidth(width, HorizAnchor.Left);
        }
        return c.textInJustified(text, box, valign);
    }
}
