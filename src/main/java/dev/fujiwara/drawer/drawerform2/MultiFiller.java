package dev.fujiwara.drawer.drawerform2;

import dev.fujiwara.drawer.Box;
import dev.fujiwara.drawer.DrawerCompiler;

public class MultiFiller implements Multi {
    @Override
    public Box render(FormCompiler c, Box box, DrawerCompiler.VAlign valign) {
        return box;
    }
}
