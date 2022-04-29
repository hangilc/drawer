package dev.fujiwara.drawer.drawerform2;

import dev.fujiwara.drawer.Box;
import static dev.fujiwara.drawer.DrawerCompiler.VAlign;

public interface Multi {

    Box render(FormCompiler c, Box box, VAlign valign);

    default MarkedMulti mark(String key, String description){
        return new MarkedMulti(this, key, description);
    }

}
