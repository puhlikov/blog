package ru.mail.puh2012.figure.extendfigure;

import ru.mail.puh2012.figure.Figure;

import java.util.HashMap;
import java.util.Objects;

/**
 * created by puh 18.04.19
 * create abstract class Circle extends Figure
 */

public abstract class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(Figure figure) {
        this.radius = figure.getMinSize();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius;
    }

    @Override
    public String toString() {
        return super.toString() + ":radius=" + radius;
    }

    @Override
    public double getMinSize() {
        return radius / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
