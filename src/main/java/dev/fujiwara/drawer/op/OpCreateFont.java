package dev.fujiwara.drawer.op;

import java.util.Objects;

public class OpCreateFont extends Op {

    private final String name;
    private final String fontName;
    private final double size;
    private final int weight;
    private final  boolean italic;

    public OpCreateFont(String name, String fontName, double size, int weight, boolean italic){
        super(OpCode.CreateFont);
        this.name = name;
        this.fontName = fontName;
        this.size = size;
        this.weight = weight;
        this.italic = italic;
    }

    public String getName() {
        return name;
    }

    public String getFontName() {
        return fontName;
    }

    public double getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isItalic() {
        return italic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpCreateFont that = (OpCreateFont) o;
        return Double.compare(that.size, size) == 0 && weight == that.weight && italic == that.italic && name.equals(that.name) && fontName.equals(that.fontName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fontName, size, weight, italic);
    }
}
