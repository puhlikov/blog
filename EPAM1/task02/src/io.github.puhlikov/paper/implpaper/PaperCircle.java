package ru.mail.puh2012.paper.implpaper;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Circle;
import ru.mail.puh2012.paper.IPaper;

import java.util.Objects;

/**
 * created by puh 23.04.19
 * create class PaperCircle extends class Circle & implements interface IPaper
 */

public class PaperCircle extends Circle implements IPaper {
    private Painted painted = new Painted();

    public PaperCircle(double radius) {
        super(radius);
    }

    public PaperCircle(IPaper paperFigure) {
        super((Figure) paperFigure);
        painted = paperFigure.getPainted();
    }

    @Override
    public Color getColor() {
        return painted.getColor();
    }

    @Override
    public void setColor(Color color) {
        painted.setColor(color);
    }

    @Override
    public Painted getPainted() {
        return painted;
    }

    @Override
    public String toString() {
        return super.toString() +
                " painted = " + painted.getColor();
    }

    //    @Override
//    public String toString() {
//        return super.toString() + "painted = " + painted.getColor()!=null? String.valueOf(painted.getColor()) :"no color";
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PaperCircle paperCircle = (PaperCircle) o;
        return Objects.equals(paperCircle.painted, painted);
    }
}