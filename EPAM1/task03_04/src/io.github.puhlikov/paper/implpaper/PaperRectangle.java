package ru.mail.puh2012.paper.implpaper;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Rectangle;
import ru.mail.puh2012.paper.IPaper;

import java.util.Objects;

/**
 * created by puh 23.04.19
 * create class PaperRectangle extends class Rectangle & implements interface IPaper
 */

public class PaperRectangle extends Rectangle implements IPaper {
    private Painted painted = new Painted();

    public PaperRectangle(double width, double heigth) {
        super(width, heigth);
    }

    public PaperRectangle(IPaper paperFigure) {
        super((Figure) paperFigure);
        painted = paperFigure.getPainted();
    }

    @Override
    public Color getColor() {
        return painted.getColor();
    }

    @Override
    public void setColor(Color color) {
        painted. setColor (color);
    }

    @Override
    public Painted getPainted(){
        return painted;
    }

    @Override
    public String toString(){
        return super.toString() + "painted = " + painted.getColor();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PaperRectangle paperRectangle = (PaperRectangle) o;
        return Objects.equals(paperRectangle.painted, painted);
    }
}
