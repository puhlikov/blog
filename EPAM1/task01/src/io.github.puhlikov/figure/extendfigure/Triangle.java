package ru.mail.puh2012.figure.extendfigure;

import ru.mail.puh2012.figure.Figure;

import java.util.Objects;

/**
 * created by puh 18.04.19
 * create abstract class Triangle extends Figure
 */

public abstract class Triangle extends Figure {
    private double sideA;

    public Triangle(double sideA) {
        this.sideA = sideA;
    }

    public Triangle(Figure figure) {
        this.sideA = figure.getMinSize() / 3;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {

        this.sideA = sideA;
    }


    @Override
    public double getArea() {
        return ((Math.sqrt(3)/4) * sideA * sideA);
    }

    @Override
    public double getPerimeter() {
        return (3*sideA);
    }

    @Override
    public String toString() {
        return super.toString() + ":sideA=" + sideA;
    }

    @Override
    public double getMinSize() {
        return sideA;
    }

    @Override
    public boolean equals (Object o){
        if (this==o) return  true;
        if (!super.equals(o)) return false;
        Triangle triangle=(Triangle) o;
        return Double.compare(triangle.sideA, sideA)==0;
    }
    @Override
    public int hashCode(){
        return Objects.hash (sideA);
    }
}
