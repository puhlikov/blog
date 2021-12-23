package ru.mail.puh2012.paper.implpaper;

/**
 * created by puh 21.04.19
 * create class PaperTriangle extends class Triangle & implements interface IPaper
 */

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Triangle;
import ru.mail.puh2012.paper.IPaper;

import java.util.Objects;

public class PaperTriangle extends Triangle implements IPaper {
    private Painted painted = new Painted();

    public PaperTriangle(double sideA) {
        super(sideA);
    }

    public PaperTriangle(IPaper paperFigure) {
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
        PaperTriangle paperTriangle = (PaperTriangle) o;
        return Objects.equals(paperTriangle.painted, painted);
    }
}
