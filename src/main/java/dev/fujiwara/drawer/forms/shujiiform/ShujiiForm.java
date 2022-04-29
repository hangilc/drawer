package dev.fujiwara.drawer.forms.shujiiform;

import dev.fujiwara.drawer.op.Op;
import dev.fujiwara.drawer.form.Box;
import dev.fujiwara.drawer.form.FormCompiler;
import dev.fujiwara.drawer.form.HAlign;
import dev.fujiwara.drawer.form.VAlign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShujiiForm {

    private final FormCompiler c = new FormCompiler();
    private final Map<String, Box> marks = new HashMap<>();

    public ShujiiForm(){
        c.createFont("small", "MS Gothic", 3);
        c.createFont("regular", "MS Gothic", 3.8);
    }

    public FormCompiler getCompiler(){
        return c;
    }

    public List<Op> render(ShujiiData data){

        // old format
//        leftBox(new Box(40, 59-15, 40+97, 59));
//        rightBox(new Box(210-56, 56.5-10, 210-13, 56));
//        detail(new Box(12.5, 150, 210-11, 380));

        // new format (2021-02-15)
        leftBox(new Box(45, 80, 110, 95));
        rightBox(new Box(133, 85, 176, 95));
        detail(new Box(22, 164, 195, 185));
        if( data != null ){
            writeSmall("doctorName", data.doctorName);
            writeSmall("clinicName", data.clinicName);
            writeSmall("clinicAddress", data.clinicAddress);
            writeSmall("phone", data.phone);
            writeSmall("fax", data.fax);
            writeRegularPara("detail", data.detail);
        }
        return c.getOps();
    }

    private void writeSmall(String mark, String value){
        if( value != null && !value.isEmpty() ){
            c.setFont("small");
            Box box = marks.get(mark);
            c.textAt(value, box.getLeft(), box.cy(), HAlign.Left, VAlign.Center);
        }
    }

    private void writeRegularPara(String mark, String value){
        if( value != null && !value.isEmpty() ){
            c.setFont("regular");
            Box box = marks.get(mark);
            c.paraIn(value, box);
        }
    }

    private void leftBox(Box box){
        List<Box> rows = box.splitToEvenRows(3);
        marks.put("doctorName", rows.get(0));
        marks.put("clinicName", rows.get(1));
        marks.put("clinicAddress", rows.get(2));
    }

    private void rightBox(Box box){
        List<Box> rows = box.splitToEvenRows(2);
        marks.put("phone", rows.get(0));
        marks.put("fax", rows.get(1));
    }

    private void detail(Box box){
        marks.put("detail", box.inset(2, 1, 2, 0));
    }

}
