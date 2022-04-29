package dev.fujiwara.drawer.forms.textform;

import dev.fujiwara.drawer.op.Op;
import dev.fujiwara.drawer.form.Box;
import dev.fujiwara.drawer.form.FormCompiler;
import dev.fujiwara.drawer.form.Paper;

import java.util.Collections;
import java.util.List;

public class TextForm {

    FormCompiler c = new FormCompiler();

    public List<List<Op>> render(TextData data){
        Paper paper = Paper.A4;
        Box pageBox = new Box(0, 0, paper.getWidth(), paper.getHeight());
        Box contentBox = pageBox.inset(data.leftMargin, data.topMargin, data.rightMargin, data.bottomMargin);
        c.createFont("regular", data.fontName, data.fontSize);
        c.setFont("regular");
        c.paraIn(data.text, contentBox, data.leading);
        return Collections.singletonList(c.getOps());
    }

}
