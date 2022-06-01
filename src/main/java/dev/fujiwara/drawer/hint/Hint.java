package dev.fujiwara.drawer.hint;

import dev.fujiwara.drawer.Box;
import dev.fujiwara.drawer.DrawerCompiler;

public interface Hint {
    Box render(DrawerCompiler compiler, Box box, String s);

    static Box render(DrawerCompiler compiler, Box box, String s, Hint hint) {
        if (hint == null) {
            return compiler.textIn(s, box, DrawerCompiler.HAlign.Left, DrawerCompiler.VAlign.Top);
        } else {
            return hint.render(compiler, box, s);
        }
    }

    static Box render(DrawerCompiler compiler, Box box, String s, String hintSrc) {
        return render(compiler, box, s, HintParser.parse(hintSrc));
    }

}
