package dev.fujiwara.drawer.hint;

import dev.fujiwara.drawer.Box;
import dev.fujiwara.drawer.DrawerCompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParaHint extends HintBase implements Hint {

    private double leading = 0;

    private final static Pattern patLeading = Pattern.compile("leading\\(([0-9.]+)\\)");

    public ParaHint(String[] args) {
        for (String a : args) {
            if (a == null || "para".equals(a) || parse(a)) {
                continue;
            }
            Matcher m = patLeading.matcher(a);
            if (m.matches()) {
                this.leading = Double.parseDouble(m.group(1));
                continue;
            }
            throw new RuntimeException("Unknown hint: " + a);
        }
    }

    @Override
    public Box render(DrawerCompiler compiler, Box box, String s) {
        box = adjustBox(box);
        String font = getFont();
        if (font != null) {
            compiler.pushFont();
            compiler.setFont(font);
        }
        Box b = compiler.paragraph(s, box, getHAlign(), getVAlign(), leading);
        if (font != null) {
            compiler.popFont();
        }
        return b;
    }

    public double getLeading(){
        return leading;
    }

}
