package dev.fujiwara.drawer.hint;

import dev.fujiwara.drawer.Box;
import static dev.fujiwara.drawer.DrawerCompiler.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HintBase {

    private double leftPadding = 0;
    private double topPadding = 0;
    private double rightPadding = 0;
    private double bottomPadding = 0;
    private HAlign halign = HAlign.Left;
    private VAlign valign = VAlign.Top;
    private String font = null;

    private final static Pattern patLeftPadding =
            Pattern.compile("left-padding\\(([0-9.]+)\\)");
    private final static Pattern patTopPadding =
            Pattern.compile("top-padding\\(([0-9.]+)\\)");
    private final static Pattern patRightPadding =
            Pattern.compile("right-padding\\(([0-9.]+)\\)");
    private final static Pattern patBottomPadding =
            Pattern.compile("bottom-padding\\(([0-9.]+)\\)");
    private final static Pattern patPadding =
            Pattern.compile("padding\\(([0-9.]+)\\)");
    private final static Pattern patXPadding =
            Pattern.compile("x-padding\\(([0-9.]+)\\)");
    private final static Pattern patYPadding =
            Pattern.compile("y-padding\\(([0-9.]+)\\)");
    private final static Pattern patDefaultVAlign =
            Pattern.compile("default-v-align\\((top|center|bottom)\\)");
    private final static Pattern patFont = Pattern.compile("font\\((.+)\\)");

    public boolean parse(String s){
        Matcher m;
        m = patDefaultVAlign.matcher(s);
        if( m.matches() ){
            switch(m.group(1)){
                case "top": this.valign = VAlign.Top; break;
                case "center": this.valign = VAlign.Center; break;
                case "bottom": this.valign = VAlign.Bottom; break;
                default: throw new RuntimeException("Invalid valign: " + m.group(1));
            }
            return true;
        }
        m = patLeftPadding.matcher(s);
        if( m.matches() ){
            this.leftPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patTopPadding.matcher(s);
        if( m.matches() ){
            this.topPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patRightPadding.matcher(s);
        if( m.matches() ){
            this.rightPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patBottomPadding.matcher(s);
        if( m.matches() ){
            this.bottomPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patPadding.matcher(s);
        if( m.matches() ){
            this.leftPadding = this.topPadding =
                    this.rightPadding = this.bottomPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patXPadding.matcher(s);
        if( m.matches() ){
            this.leftPadding = this.rightPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patYPadding.matcher(s);
        if( m.matches() ){
            this.topPadding = this.bottomPadding = Double.parseDouble(m.group(1));
            return true;
        }
        m = patFont.matcher(s);
        if( m.matches() ){
            this.font = m.group(1);
            return true;
        }
        switch(s){
            case "left": {
                this.halign = HAlign.Left;
                return true;
            }
            case "right": {
                this.halign = HAlign.Right;
                return true;
            }
            case "center": {
                this.halign = HAlign.Center;
                return true;
            }
            case "v-top": {
                this.valign = VAlign.Top;
                return true;
            }
            case "v-bottom": {
                this.valign = VAlign.Bottom;
                return true;
            }
            case "v-center": {
                this.valign = VAlign.Center;
                return true;
            }
        }
        return false;
    }

    public Box adjustBox(Box box){
        return box.inset(leftPadding, topPadding, rightPadding, bottomPadding);
    }

    public HAlign getHAlign(){
        return halign;
    }

    public VAlign getVAlign(){
        return valign;
    }

    public String getFont(){
        return font;
    }

}
